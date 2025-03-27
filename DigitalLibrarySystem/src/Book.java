public class Book {
    private final String id;
    private String title;
    private String author;
    private final String genre;
    private String status;

    public Book(String id, String title, String author, String genre, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (!author.isEmpty()) {
            this.author = author;
        }
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("Available") || status.equals("Checked Out")) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return String.format("Book ID: %s, Title: %s, Author: %s, Genre: %s, Status: %s",
                id, title, author, genre, status);
    }
}
