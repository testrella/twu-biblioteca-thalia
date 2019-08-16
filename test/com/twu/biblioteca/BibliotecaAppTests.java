package com.twu.biblioteca;


import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.*;

public class BibliotecaAppTests {

    @Test
    public void welcomeMessageShouldSay() {
        //Given
        BibliotecaApp testApp = new BibliotecaApp();

        //When
        String result = testApp.sayWelcome();

        //Then
        assertThat(result, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore"));
    }

    @Test
    public void printsWelcomeMessageToStream() {
        //Given
        BibliotecaApp testApp = new BibliotecaApp();
        ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
        PrintStream printer = new PrintStream(byteArr);


        //When
        testApp.printWelcomeMessage(printer);

        //Then
        assertThat(byteArr.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore"));
    }

    @Test
    public void printsListOfBooksToStream() {
        //Given
        BibliotecaApp testApp = new BibliotecaApp();
        ByteArrayOutputStream bookByteArr = new ByteArrayOutputStreamEx();
        PrintStream printer = new PrintStream(bookByteArr);
        List<String> bookList = Arrays.asList("1984", "Mockingbird", "The Hobbit");

        //When
        testApp.printBookList(printer, bookList);

        //Then
        assertThat(bookByteArr.toString(), is("1984\nMockingbird\nThe Hobbit\n"));
    }
}
