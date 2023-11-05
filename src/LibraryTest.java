import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setup() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testSearchByTitle() {
        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);
        Book foundBook = library.searchByTitle("Book 1");
        assertNotNull(foundBook);
        assertEquals("Book 1", foundBook.getTitle());
    }

    @Test
    public void testSearchByTitleNotFound() {
        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);
        Book foundBook = library.searchByTitle("Non-Existent Book");
        assertNull(foundBook);
    }

    @Test
    public void testDeleteBookByISBN() {
        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);
        boolean deleted = library.deleteBookByISBN("1234567890");
        assertTrue(deleted);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testDeleteBookByISBNNotFound() {
        Book book1 = new Book("Book 1", "Author 1", "1234567890", 2020);
        library.addBook(book1);
        boolean deleted = library.deleteBookByISBN("Non-Existent ISBN");
        assertFalse(deleted);
        assertEquals(1, library.getBooks().size());
    }
}
