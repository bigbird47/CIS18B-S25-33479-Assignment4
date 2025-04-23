package libraryTest;

//Brian Siebert
//CIS-18B
//Lesson 4 Assignment

import java.util.*;

//=============================
//Exception Classes
//=============================
class BookNotAvailableException extends Exception {
 public BookNotAvailableException(String message) {
     super(message);
 }
}