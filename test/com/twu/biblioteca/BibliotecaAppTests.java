package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BibliotecaAppTests {

    BibliotecaApp testApp;
    ByteArrayOutputStream output;
    PrintStream printer;
    List<Book> bookList;
    MockScannerWrapper mockScanner;

    @Before
    public void setUp() throws Exception {
        //Given
        testApp = new BibliotecaApp();
        output = new ByteArrayOutputStream();
        printer = new PrintStream(output);
        bookList = new ArrayList<Book>();
        mockScanner = new MockScannerWrapper();
    }


    @Test
    public void shouldPrintWelcomeMessage() {
        //Given setUp()

        //When
        testApp.printWelcome(printer);

        //Then
        assertThat(output.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n"));
    }

    @Test
    public void shouldPrintListOfBooks() {
        //Given
        bookList.add(new Book("Like Water for Chocolate", "Laura Esquivel", 1992));

        //When
        testApp.printBookList(printer, bookList);

        //Then
        assertThat(output.toString(), is("Like Water for Chocolate, Laura Esquivel, 1992\n"));
    }
    

    @Test
    public void shouldReadUserInputAtStartAndReportInvalidOptionWhenPress2(){
        //Given
        String expected =( "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n" + "Menu:\n" + "For list of books press 1\n" + "Please select a valid option");
        bookList.add(new Book("Caramelo", "Sandra Cisneros", 2002));

        //When
        testApp.start(printer, bookList, mockScanner);

        //Then
        assertThat(output.toString(), is(expected));

    }

}
