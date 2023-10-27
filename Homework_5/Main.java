package Homework_5;

public class Main {
    public static void main(String[] args) {
        ContactsRepository repositroy = new ContactsRepository();
        PhoneBook book = new PhoneBook(repositroy);
        book.newContact("Ivan", "9176162020");
        book.print();
        book.newContact("Damir", "9056055565");
        book.findContact("Ivan");
        System.out.println(book.call(2));
    }
}
