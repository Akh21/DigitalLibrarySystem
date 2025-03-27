import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        library.addBook("1", "Java Basics", "John Doe", "Programming", "Available");
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void testAddDuplicateBookId() {
        library.addBook("1", "Java Basics", "John Doe", "Programming", "Available");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBook("1", "Python Basics", "Jane Doe", "Programming", "Available")
        );
        assertEquals("Error: Book ID must be unique!", exception.getMessage());
    }

    @Test
    void testSearchBook() {
        library.addBook("1", "Java Basics", "John Doe", "Programming", "Available");
        assertNotNull(library.searchBook("1"));
        assertNotNull(library.searchBook("Java Basics"));
        assertNull(library.searchBook("Non-Existing Book"));
    }

    @Test
    void testUpdateBook() {
        library.addBook("1", "Java Basics", "John Doe", "Programming", "Available");
        library.updateBook("1", "Advanced Java", "John Smith", "Checked Out");
        Book book = library.searchBook("1");
        assertEquals("Advanced Java", book.getTitle());
        assertEquals("John Smith", book.getAuthor());
        assertEquals("Checked Out", book.getStatus());
    }

    @Test
    void testDeleteBook() {
        library.addBook("1", "Java Basics", "John Doe", "Programming", "Available");
        library.deleteBook("1");
        assertEquals(0, library.getBooks().size());
    }
}
