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
        output = new ByteArrayOutputStream();
        printer = new PrintStream(output);
        bookList = new ArrayList<Book>();
        mockScanner = new MockScannerWrapper();
        testApp = new BibliotecaApp(output, printer, bookList, mockScanner);
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
        //Given
        bookList.add(new Book("Like Water for Chocolate", "Laura Esquivel", 1992));

        //When
        testApp.printBookList();

        //Then
        assertThat(output.toString(), is("Like Water for Chocolate, Laura Esquivel, 1992\n"));
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

    @Test
    public void shouldCloseScannerWhenUserQuits(){
        //Given

        //When
        //testApp.start();
    }


}
