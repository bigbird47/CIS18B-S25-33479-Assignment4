package libraryTest;

//Brian Siebert
//CIS-18B
//Lesson 4 Assignment

import java.util.*;

// =============================
// LibraryCollection Class
// =============================
class LibraryCollection {
    private Map<String, List<Book>> genreMap;

    public LibraryCollection() {
        genreMap = new HashMap<>();
    }

    public void addBook(Book book) {
        // TODO: Add books to genreMap
        genreMap.computeIfAbsent(book.getGenre(), k -> new ArrayList<>()).add(book);
    }

    public Iterator<Book> getGenreIterator(String genre) {
        // TODO: Return custom iterator for available books in that genre
        List<Book> books = genreMap.getOrDefault(genre, new ArrayList<>());
      return new AvailableBookIterator(books);
    }

    // TODO: Add methods to search and return books
    public void borrowBook(String genre, String title) throws BookNotFoundException, BookNotAvailableException {
        List<Book> books = genreMap.get(genre);
        if (books == null) throw new BookNotFoundException("No books found in genre: " + genre);
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkout();
                return;
            }
        }
        throw new BookNotFoundException("Book not found: " + title);
    }

  public void returnBook(String genre, String title) throws BookNotFoundException {
      List<Book> books = genreMap.get(genre);
      if (books == null) throw new BookNotFoundException("No books found in genre: " + genre);
      for (Book book : books) {
          if (book.getTitle().equalsIgnoreCase(title)) {
              book.returnBook();
              return;
          }
      }
      throw new BookNotFoundException("Book not found: " + title);
  }

  private static class AvailableBookIterator implements Iterator<Book> {
      private final Iterator<Book> iterator;
      private Book nextAvailable;

    public AvailableBookIterator(List<Book> books) {
      iterator = books.iterator();
      advance();
    }

    private void advance() {
      nextAvailable = null;
      while (iterator.hasNext()) {
        Book next = iterator.next();
        if (next.isAvailable()) {
          nextAvailable = next;
          break;
        }
      }
    }

    @Override
    public boolean hasNext() {
      return nextAvailable != null;
    }

    @Override
    public Book next() {
      if (nextAvailable == null) throw new NoSuchElementException();
      Book result = nextAvailable;
      advance();
      return result;
    }
  }
}