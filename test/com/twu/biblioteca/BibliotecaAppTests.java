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
    List<Book> bookList;

    @Before
    public void setUp() throws Exception {
        //Given
        testApp = new BibliotecaApp();
        output = new ByteArrayOutputStream();
        printer = new PrintStream(output);
        bookList = new ArrayList<Book>();
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
    public void shouldPrintWelcomeMessageAndBookListAtStart() {
        //Given
        bookList.add(new Book("Like Water for Chocolate", "Laura Esquivel", 1992));
        bookList.add(new Book("Caramelo", "Sandra Cisneros", 2002));

        //When
        testApp.start(printer, bookList);

        //Then
        assertThat(output.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n" +
                "Like Water for Chocolate, Laura Esquivel, 1992\n" +
                "Caramelo, Sandra Cisneros, 2002\n"));
    }

}
