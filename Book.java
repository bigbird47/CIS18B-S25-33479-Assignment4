package libraryTest;

//Brian Siebert
//CIS-18B
//Lesson 4 Assignment

import java.util.*;

//=============================
//Book Class
//=============================
class Book {
 private String title;
 private String author;
 private String genre;
 private boolean isAvailable;

 public Book(String title, String author, String genre) {
     this.title = title;
     this.author = author;
     this.genre = genre;
     this.isAvailable = true;
 }

 public boolean isAvailable() {
     return isAvailable;
 }

 public void checkout() throws BookNotAvailableException {
     // TODO: Throw exception if book is not available
     if (!isAvailable) {
         throw new BookNotAvailableException("Book is not available for checkout.");
     }
     isAvailable = false;
 }

 public void returnBook() {
     // TODO: Mark book as available
     isAvailable = true;
 }

 public String getGenre() {
     return genre;
 }

 public String getTitle() {
     return title;
 }

 public String toString() {
     return title + " by " + author + " (" + genre + ")";
 }
}