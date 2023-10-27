package Homework_5;

import java.util.ArrayList;
import java.util.List;

public class ContactsRepository {
    private List<Contact> storage;

    public ContactsRepository() {
        this.storage = new ArrayList<>();
    }

    public void create(Contact newContact) {
        newContact.setId(this.storage.size() + 1);
        this.storage.add(newContact);
        save();
    }

    public void delete(int id) {
        this.storage.remove(id);
        update();
        save();
    }

    public void update() {
        int n = 1;
        for (Contact contact : storage) {
            contact.setId(n++);
        }
        save();
    }

    public List<Contact> read(String name) throws NullPointerException{
        List<Contact> detected = new ArrayList<>();
        if (this.storage.isEmpty()) throw new NullPointerException();
        for (Contact contact : storage) {
            if (contact.getFirstName().matches(name))
                detected.add(contact);
        }
        return detected;
    }

    public Contact read(int id) {
        return this.storage.get(id - 1);
    }

    public List<Contact> geContacts() {
        return this.storage;
    }

    private boolean save() {
        return true;
    }
}
