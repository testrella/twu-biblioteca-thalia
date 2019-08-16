package com.twu.biblioteca;


import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.*;

public class BibliotecaAppTests {

    BibliotecaApp testApp;
    ByteArrayOutputStream output;
    PrintStream printer;
    List<String> bookList;

    @Before
    public void setUp() throws Exception {
        //Given
        testApp = new BibliotecaApp();
        output = new ByteArrayOutputStream();
        printer = new PrintStream(output);
        bookList = Arrays.asList("1984", "Mockingbird", "The Hobbit");
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
        //Given setUp

        //When
        testApp.printBookList(printer, bookList);

        //Then
        assertThat(output.toString(), is("1984\nMockingbird\nThe Hobbit\n"));
    }

    @Test
    public void shouldPrintWelcomeMessageAndBookListAtStart() {
        //Given setUp

        //When
        testApp.start(printer, bookList);

        //Then
        assertThat(output.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n1984\nMockingbird\nThe Hobbit\n"));
    }
}
