package com.twu.biblioteca;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class BibliotecaApp {


    public BibliotecaApp(){

    }

    public void start(PrintStream printer, List<String> bookList) {
        printWelcome(printer);
        printBookList(printer, bookList);
    }

    protected void printWelcome(PrintStream printer){
        printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n");
    }

    protected void printBookList(PrintStream printer, List<String> bookList) {
        for (String book : bookList)
            printer.println(book);
    }
}
