import java.util.Scanner;
import java.util.Collection;

// Main class to run the Digital Library System
public class DigitalLibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigital Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit System");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter Availability Status (Available/Checked Out): ");
                        String status = scanner.nextLine();
                        library.addBook(id, title, author, genre, status);
                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        if (library.getBooks().isEmpty()) {
                            System.out.println("No books available.");
                        } else {
                            library.getBooks().forEach(System.out::println);
                        }
                        break;
                    case 3:
                        System.out.print("Enter Book ID or Title to search: ");
                        String searchQuery = scanner.nextLine();
                        Book foundBook = library.searchBook(searchQuery);
                        if (foundBook != null) {
                            System.out.println(foundBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Book ID to update: ");
                        String updateId = scanner.nextLine();
                        if (library.searchBook(updateId) == null) {
                            System.out.println("Error: Book not found!");
                            break;
                        }
                        System.out.print("Enter New Title (Leave blank to keep unchanged): ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Author (Leave blank to keep unchanged): ");
                        String newAuthor = scanner.nextLine();
                        System.out.print("Enter New Availability Status (Available/Checked Out, Leave blank to keep unchanged): ");
                        String newStatus = scanner.nextLine();
                        library.updateBook(updateId, newTitle, newAuthor, newStatus);
                        System.out.println("Book updated successfully!");
                        break;
                    case 5:
                        System.out.print("Enter Book ID to delete: ");
                        String deleteId = scanner.nextLine();
                        if (library.searchBook(deleteId) == null) {
                            System.out.println("Error: Book not found!");
                            break;
                        }
                        library.deleteBook(deleteId);
                        System.out.println("Book deleted successfully!");
                        break;
                    case 6:
                        System.out.println("Exiting System...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
