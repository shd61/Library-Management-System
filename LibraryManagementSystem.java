import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class representing a LibraryItem
abstract class LibraryItem {
    private String title;
    private int id;

    public LibraryItem(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}

class BookItem extends LibraryItem {
    private String author;

    public BookItem(String title, int id, String author) {
        super(title, id);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Item ID: " + getId());
    }
}

class MagazineItem extends LibraryItem {
    private String publisher;

    public MagazineItem(String title, int id, String publisher) {
        super(title, id);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Item ID: " + getId());
    }
}

class Library {
    private List<LibraryItem> libraryItems;

    public Library() {
        libraryItems = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem libraryItem) {
        libraryItems.add(libraryItem);
    }

    public void displayLibraryItems() {
        for (LibraryItem item : libraryItems) {
            item.displayInfo();
            System.out.println();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display Library Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Item ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    BookItem bookItem = new BookItem(bookTitle, bookId, author);
                    library.addLibraryItem(bookItem);
                    break;

                case 2:
                    System.out.print("Enter Magazine Title: ");
                    String magazineTitle = scanner.nextLine();

                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();

                    System.out.print("Enter Item ID: ");
                    int magazineId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    MagazineItem magazineItem = new MagazineItem(magazineTitle, magazineId, publisher);
                    library.addLibraryItem(magazineItem);
                    break;

                case 3:
                    System.out.println("Library Items:");
                    library.displayLibraryItems();
                    break;

                case 4:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
