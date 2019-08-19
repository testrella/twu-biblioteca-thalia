package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.io.ByteArrayOutputStream;


public class BibliotecaApp<Books> {
    ByteArrayOutputStream output;
    PrintStream printer;
    List<Book> bookList;
    ScannerWrapper scanner;

    public BibliotecaApp(ByteArrayOutputStream output, PrintStream printer, List<Book> bookList, ScannerWrapper scanner){
        this.output = output;
        this.printer = printer;
        this.bookList = bookList;
        this.scanner = scanner;

    }

    public void start() {
        printWelcome();
        printMenu();
        readInput();

    }

    protected void printWelcome(){
        printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n");
    }

    protected void printBookList() {
        for (Book book : bookList)
            printer.println(book.toString());
    }

    protected void printMenu(){
        printer.print("Menu:\n" + "For list of books press 1\n");
    }

    protected void readInput(){
        String input = scanner.nextLine();
        if(input.equals("1")){
            printBookList();
        }
        if(input.equals("Q")){
            quit();
        }
        else{
            printer.print("Please select a valid option");
        }
    }
    protected void quit(){
        printer.print("You have quit the app\n");
    }


}
