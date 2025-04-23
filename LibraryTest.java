package libraryTest;

//Brian Siebert
//CIS-18B
//Lesson 4 Assignment

import java.util.*;

//=============================
//Main Program
//=============================
public class LibraryTest {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     LibraryCollection library = new LibraryCollection();

     // TODO: Add sample books to library
     library.addBook(new Book("Dune", "Frank Herbert", "Science Fiction"));
     library.addBook(new Book("Different Seasons", "Stephen King", "Drama"));
     library.addBook(new Book("1984", "George Orwell", "Dystopian"));
     library.addBook(new Book("A Game of Thrones", "George R.R. Martin", "Fantasy"));
     library.addBook(new Book("The Walking Dead: Rise of the Governor", "Robert Kirkman", "Horror"));
     
     // TODO: Prompt user for genre, list available books using iterator
     boolean running = true;

     while (running) {
         System.out.print("Enter genre to list available books (or 'exit' to quit): ");
         String genre = scanner.nextLine();
         if (genre.equalsIgnoreCase("exit")) {
             running = false;
             continue;
         }
         
         Iterator<Book> iterator = library.getGenreIterator(genre);
         boolean found = false;

         System.out.println("Available books in " + genre + ":");
         while (iterator.hasNext()) {
             System.out.println(iterator.next());
             found = true;
         }
         
         if (!found)
             System.out.println("No available books found in genre: " + genre);
         System.out.println();

     // TODO: Allow checkout and return, handling exceptions
     System.out.println("Type 'checkout' to borrow a book, 'return' to return, or 'skip' to skip:");
     String action = scanner.nextLine();

     if (action.equalsIgnoreCase("checkout")) {
         System.out.println("Enter title to borrow a book:");
         String title = scanner.nextLine();
         try {
             library.borrowBook(genre, title);
             System.out.println("You have borrowed: " + title);
         } catch (BookNotFoundException | BookNotAvailableException e) {
             System.out.println(e.getMessage());
         }
         
     } else if (action.equalsIgnoreCase("return")) {
         System.out.println("Enter title to return a book:");
         String title = scanner.nextLine();
         try {
             library.returnBook(genre, title);
             System.out.println("You have returned: " + title);
         } catch (BookNotFoundException e) {
             System.out.println(e.getMessage());
         }
     }
     }
     scanner.close();
     System.out.println("End session.");
 }
}