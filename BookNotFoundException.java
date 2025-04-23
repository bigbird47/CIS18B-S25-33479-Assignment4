package libraryTest;

//Brian Siebert
//CIS-18B
//Lesson 4 Assignment

import java.util.*;

//=============================
//Exception Classes
//=============================
class BookNotFoundException extends Exception {
 public BookNotFoundException(String message) {
     super(message);
 }
}