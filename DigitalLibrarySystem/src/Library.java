import java.util.*;

// Library class for managing book operations
public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(String id, String title, String author, String genre, String status) {
        if (books.containsKey(id)) {
            throw new IllegalArgumentException("Error: Book ID must be unique!");
        }
        if (title.isEmpty() || author.isEmpty()) {
            throw new IllegalArgumentException("Error: Title and Author cannot be empty!");
        }
        if (!status.equals("Available") && !status.equals("Checked Out")) {
            throw new IllegalArgumentException("Error: Invalid status! Use 'Available' or 'Checked Out'.");
        }
        books.put(id, new Book(id, title, author, genre, status));
    }

    public Collection<Book> getBooks() {
        return books.values();
    }

    public Book searchBook(String query) {
        return books.values().stream()
                .filter(book -> book.getId().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }

    public void updateBook(String id, String newTitle, String newAuthor, String newStatus) {
        Book book = books.get(id);
        if (book == null) {
            throw new IllegalArgumentException("Error: Book not found!");
        }
        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (!newStatus.isEmpty()) book.setStatus(newStatus);
    }

    public void deleteBook(String id) {
        if (books.remove(id) == null) {
            throw new IllegalArgumentException("Error: Book not found!");
        }
    }
}
