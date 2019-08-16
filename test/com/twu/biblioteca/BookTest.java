package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class BookTest {


    @Test
    public void shouldWriteBookInfoAndReturnAsString() {
        //Given
        Book testBook = new Book("Like Water For Chocolate", "Laura Esquivel", 1992);

        //When
        String bookInfo = testBook.toString();
        //Then
        assertThat(bookInfo, is(String.join(", ", "Like Water For Chocolate", "Laura Esquivel", Integer.toString(1992))));
    }


}