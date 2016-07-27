package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;

    @Before
    public void initTests() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        Library library = createLibrary();

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = createLibrary();
        library.listBooks();
        verify(printStream, never()).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String firstTitle = "First";
        String secondTitle = "Second";
        books.add(firstTitle);
        books.add(secondTitle);
        Library library = createLibrary();

        library.listBooks();

        verify(printStream).println(firstTitle);
        verify(printStream).println(secondTitle);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        Library library = createLibrary();

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = createLibrary();
        library.welcome(time);

        // add a verify here
        verify(printStream).println(contains("The current time is "));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        DateTime time = new DateTime();
        String timeString = "5:00 PM";

        when(dateTimeFormatter.print(time)).thenReturn(timeString);

        Library library = createLibrary();
        library.welcome(time);

        verify(printStream).println(contains(timeString));
    }

    private Library createLibrary() {
        return new Library(books, printStream, dateTimeFormatter);
    }
}
