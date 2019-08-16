package com.twu.biblioteca;


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
}
