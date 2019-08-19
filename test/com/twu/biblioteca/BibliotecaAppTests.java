package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class BibliotecaAppTests {

    BibliotecaApp testApp;
    ByteArrayOutputStream output;
    PrintStream printer;
    List<Book> bookList;
    MockScannerWrapper mockScanner;

    @Before
    public void setUp() throws Exception {
        //Given
        output = new ByteArrayOutputStream();
        printer = new PrintStream(output);
        bookList = new ArrayList<Book>();
        mockScanner = new MockScannerWrapper();
        testApp = new BibliotecaApp(output, printer, bookList, mockScanner);
        bookList.add(new Book("Like Water for Chocolate", "Laura Esquivel", 1992));
        bookList.add(new Book("Caramelo", "Sandra Cisneros", 2002));
    }


    @Test
    public void shouldPrintWelcomeMessage() {
        //Given setUp()

        //When
        testApp.printWelcome();

        //Then
        assertThat(output.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n"));
    }

    @Test
    public void shouldPrintListOfBooks() {
        //Given setUp()

        //When
        testApp.printBookList();

        //Then
        assertThat(output.toString(), is("Like Water for Chocolate, Laura Esquivel, 1992\n" + "Caramelo, Sandra Cisneros, 2002\n"));
    }



    @Test
    public void shouldQuitWhenUserInputIsQ(){
        //Given
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n" + "Menu:\n" + "For list of books press 1\n" +"You have quit the app\n";

        //When
        testApp.start();

        //Then
        assertThat(output.toString(), is(expected));

    }

    /**
    @Test
    public void shouldCloseScannerWhenUserQuits(){
        //Given

        //When
        testApp.start();

        //Then
        assertThat()
    }
    */

    @Test
    public void shouldReportTrueIfBookIsAvailable(){
        //Given
        String bookTitle = "Caramelo";
        Book bookToBeRemoved = null;

        boolean available = testApp.isBookAvailable(bookTitle);

        assertTrue(available);
    }

    @Test
    public void shouldReportFalseIfBookIsNotAvailable(){
        //Given
        String bookTitle = "Not Your Perfect Mexican Daughter";
        Book bookToBeRemoved = null;

        boolean available = testApp.isBookAvailable(bookTitle);

        assertFalse(available);
    }

    @Test
    public void shouldReportFalseIfBookIsCheckedOut(){
        //Given
        String bookTitle = "Caramelo";
        Book bookToBeRemoved = null;

        //When
        testApp.checkoutBook(bookTitle);

        //Then
        for (Book book : bookList){
            if (book.getTitle().equals(bookTitle)){
                bookToBeRemoved = book;
            }
        }
        assertFalse(bookList.contains(bookToBeRemoved));

    }

    @Test
    public void shouldPrintThankYouMessageWhenBookIsCheckedOut(){
        //Given setUp()
        String bookTitle = "Caramelo";
        Book bookToBeRemoved = null;
        String expected = "Thank you! Enjoy the book";

        //When
        testApp.checkoutBook(bookTitle);

        //Then
        assertThat(output.toString(), is(expected));

    }

    @Test
    public void shouldPrintSorryMessageWhenBookIsNotAvailable() {
        //Given setUp()
        String bookTitle = "Not Your Perfect Mexican Daughter";
        Book bookToBeRemoved = null;
        String expected = "Sorry, that book is not available";

        //When
        testApp.checkoutBook(bookTitle);

        //Then
        assertThat(output.toString(), is(expected));
    }


}
