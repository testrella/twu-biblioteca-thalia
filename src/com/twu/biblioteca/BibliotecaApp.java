package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp<Books> {

    public BibliotecaApp(){


    }

    public void start(PrintStream printer, List<Book> bookList, ScannerWrapper scanner) {
        printWelcome(printer);
        printMenu(printer);
        readInput(printer, scanner);

    }

    protected void printWelcome(PrintStream printer){
        printer.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n");
    }

    protected void printBookList(PrintStream printer, List<Book> bookList) {
        for (Book book : bookList)
            printer.println(book.toString());
    }

    protected void printMenu(PrintStream printer){
        printer.print("Menu:\n" + "For list of books press 1\n");
    }

    protected void readInput(PrintStream printer, ScannerWrapper scanner){
        String input = scanner.nextLine();
        if(!input.equals("1")){
            printer.print("Please select a valid option");
        }

    }


}
