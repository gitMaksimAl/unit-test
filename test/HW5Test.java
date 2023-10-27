package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Homework_5.Contact;
import Homework_5.ContactsRepository;
import Homework_5.PhoneBook;

@TestInstance(Lifecycle.PER_CLASS)
public class HW5Test {
    
    private Contact contactMock;
    
    @BeforeAll
    public void setup() {
        contactMock = mock(Contact.class);
        when(contactMock.getAge()).thenReturn(ThreadLocalRandom.current().nextInt(3));
        when(contactMock.getEmail()).thenReturn("ivan@sobaka.com");
        when(contactMock.getFirstName()).thenReturn("Ivan");
        when(contactMock.getLastName()).thenReturn("Redjka");
        when(contactMock.getPhone()).thenReturn("9176162312");
        when(contactMock.getAge()).thenReturn(ThreadLocalRandom.current().nextInt(77));
        when(contactMock.getId()).thenReturn(ThreadLocalRandom.current().nextInt(1));

    }

    // unit tests
    // region
    // phonebook tests, using mock for dependencies
    // тесты книги контактов проверяют: коды ответа при вызове контакта и обращение к репозиторию при поиске контакта
    @Test
    public void phonebookUnitTest() {
        List<Contact> listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        when(listMock.get(anyInt())).thenReturn(contactMock);
        ContactsRepository repositoryMock = mock(ContactsRepository.class);
        when(repositoryMock.read(anyInt())).thenReturn(contactMock);
        when(repositoryMock.read(anyString())).thenReturn(listMock);
        PhoneBook book = new PhoneBook(repositoryMock);

        assertThat(book.call(1)).contains("Hello");
        // WARNING: test can not pass when running all
        assertThat(book.sendMail(1)).contains("200");
        book.findContact("Ivan");
        verify(repositoryMock.read("Ivan"), times(1));
    }

    // тесты контакта проверяют: что при создании задается значение поля "имя" равное заданной строке
    @Test
    public void contactUnitTest() {
        Contact friend1 = new Contact("Ivan");

        assertThat(friend1.getFirstName()).isNotEmpty();
        assertThat(friend1).hasFieldOrPropertyWithValue("firstName", "Ivan");
    }

    // тесты репозитория проверяют: добавление контакта(мок-объект) в репозиторий
    // возврат метода поиска по имени и соответствие адреса емэйл с маской
    @Test
    public void repositoryUnitTest() {
        ContactsRepository repository = new ContactsRepository();

        repository.create(contactMock);
        assertThat(repository.read("Ivan")).allMatch(contact -> contact.getFirstName().contains("Ivan"));
        assertThat(repository.read(1)).extracting((contact) -> contact.getEmail().matches("\\w*@\\w*\\.\\w{2,3}"));
        when(contactMock.getEmail()).thenReturn("ivan.balagan.ru");
        assertFalse(repository.read(1).getEmail().matches("\\w*@\\w*\\.\\w{2,3}"));
    }
    // endregion

    // integration testing
    // интеграционный тест книги контактов и её репозитория проверяют: коды возвратов во время вызова и отправки емэйл,
    // при их наличии или отсутствии
    @Test
    public void phonebookIntegrationTest() {
        ContactsRepository repository = new ContactsRepository();
        PhoneBook book = new PhoneBook(repository);
        Contact friend_one = new Contact("Vasja");
        Contact friend_two = new Contact("Petja");
        repository.create(friend_one);
        repository.create(friend_two);

        assertThat(book.call(1)).isEqualTo("Have not number.");
        friend_one.setPhone("9056055565");
        assertThat(book.call(1)).contains("Hello");
        friend_two.setEmail("petja@japetja.com");
        assertThat(book.sendMail(2)).isEqualTo("200");
    }

    // for E2E test run Homework_5.Main.java
}
