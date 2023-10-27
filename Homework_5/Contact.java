package Homework_5;

public class Contact {
    
    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public Contact(String name, String phoneNumber) {
        this.firstName = name;
        this.phone = phoneNumber;
    }

    public Contact(String name) {
        this.firstName = name;
    }

    public void setId(int n) {
        this.id = n;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
