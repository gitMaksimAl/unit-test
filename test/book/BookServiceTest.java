package test.book;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Answers.RETURNS_SMART_NULLS;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import Lesson_4.book.Book;
import Lesson_4.book.BookService;
import Lesson_4.book.InMemoryBookRepository;

@TestInstance(Lifecycle.PER_CLASS)
class BookServiceTest {
    String[] AUTHORS = {"Anton", "Georgiy", "Boris", "Arseniy"};
    String[] TITLES = {"Python", "Java", "C", "Pascal"};

    // dependencies
    private InMemoryBookRepository fakeRepo;
    private Book anyBook;
    private List<Book> books;

    // testing object
    private BookService service;

    @BeforeAll
    public void setup() {

        fakeRepo = mock(InMemoryBookRepository.class, withSettings().defaultAnswer(RETURNS_SMART_NULLS));
        anyBook = mock(Book.class);
        books = mock(List.class);


        service = new BookService(fakeRepo);

        when(anyBook.getId()).thenReturn(String.valueOf(ThreadLocalRandom.current().nextInt(122)));
        when(anyBook.getAuthor()).thenReturn(AUTHORS[ThreadLocalRandom.current().nextInt(AUTHORS.length)]);
        when(anyBook.getTitle()).thenReturn(TITLES[ThreadLocalRandom.current().nextInt(TITLES.length)]);

        when(books.size()).thenReturn(AUTHORS.length * TITLES.length);
        when(books.get(anyInt())).thenReturn(anyBook);

        when(fakeRepo.findById(matches("\\d"))).thenReturn(anyBook);
        when(fakeRepo.findById(matches("\\D"))).thenThrow(new NullPointerException());
        when(fakeRepo.findAll()).thenReturn(books);
    }

    @Test
    public void serviceTest() {
        assertThat(service.findBookById("1")).isInstanceOf(Book.class);
        assertThrows(NullPointerException.class, () -> {service.findBookById("wrong");});
        assertThat(service.findAllBooks()).isInstanceOf(List.class);
        assertThat(service.findAllBooks().get(1)).doesNotReturn(NullPointerException.class, Book::getAuthor);
        assertThat(service.findAllBooks().get(1)).doesNotReturn(NullPointerException.class, Book::getTitle);
    }
}