package Homework_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteBook {
    private ContactsRepository repository;
    private List<Contact> trash;
    private Scanner scanner;

    public NoteBook(ContactsRepository repo) {
        this.repository = repo;
        this.trash = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void newContact(String name, String phone) {
        Contact newContact = new Contact(name);
        String input;
        try {
            if (!phone.matches("\\d{10,11}"))
                throw new NumberFormatException("Wrong email.");
            newContact.setPhone(phone);
            System.out.println("Email: ");
            input = scanner.nextLine();
            if (!input.matches("\\w*@\\.\\w{2,3}"))
                throw new NumberFormatException("Wrong email.");
            newContact.setEmail(input);
            System.out.println("Age: ");
            newContact.setAge(Integer.parseInt(this.scanner.nextLine()));
            System.out.println("Last name: ");
            input = scanner.nextLine();
            if (!input.matches("\\D*"))
                throw new NumberFormatException("Wrong last name.");
            newContact.setLastName(this.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Try again.");
        }
        this.repository.create(newContact);
    }

    public void findContact(String name) {
        try {
            for (Contact contact : this.repository.read(name)) {
                System.out.println(String.format("%d %s %s",
                    contact.getId(),
                    contact.getFirstName(),
                    contact.getLastName() != null ? contact.getLastName(): " "));
            }
        } catch (NullPointerException nl) {
            System.out.println("");
        }
    }

    public void delete(Contact contact) {
        contact.setId(this.trash.size() + 1);
        this.trash.add(contact);
        this.repository.delete(contact.getId() - 1);
    }

    public void close() {
        this.scanner.close();
    }

    public String sendMail(int id) {
        if (this.repository.read(id).getEmail().isEmpty()) return "400";
        return "200";
    }

    public String call(int id) {
        if (this.repository.read(id).getPhone().isEmpty()) return "Have not number.";
        return "Hello";
    }

    public void print() {
        findContact("\\w*");
    }
}
