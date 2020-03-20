package day4.ex2;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AuthorServiceImplTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Setup is calling");
    }

    public void testGetTotalBooksExceptBookWithNameBot() {
        System.out.println("testGetTotalBooks");

        final int EXPECTED_BOT_COUNT = 2;

        String authorName = "Author";

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("bot"));
        bookList.add(new Book("book 1"));
        bookList.add(new Book("book 2"));

        BookService mockedBookService = mock(BookService.class);

        AuthorServiceImpl authorService = new AuthorServiceImpl();
        authorService.setBookService(mockedBookService);
        authorService.setBookValidatorService(new BookValidatorServiceImpl());

        when(mockedBookService.findBookByAuthor(authorName)).thenReturn(bookList);

        assertEquals("The bot books count should be " + EXPECTED_BOT_COUNT, EXPECTED_BOT_COUNT
                , authorService.getTotalBooks(authorName));

        verify(mockedBookService, times(1)).findBookByAuthor(authorName);
    }

    public void testGetTotalBooksToReturnHarryPotterBooks(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter and the Philosopher's Stone"));
        bookList.add(new Book("Harry Potter and the Chamber of Secrets"));
        bookList.add(new Book("Harry Potter and the Prisoner of Azkaban"));
        bookList.add(new Book("Harry Potter and the Goblet of Fire"));
        bookList.add(new Book("The Perks of being a wallflower"));
        bookList.add(new Book("Readit and weep it"));

        final String AUTHOT_JK_ROWLING = "J.K Rowling";

        BookService mockedBookService  = mock(BookService.class);
        BookValidatorService mockedBookValidatorServiceForHPBooks = mock(BookValidatorService.class);

        AuthorServiceImpl authorService  = new AuthorServiceImpl();
        authorService.setBookService(mockedBookService);
        authorService.setBookValidatorService(mockedBookValidatorServiceForHPBooks);

        when(mockedBookService.findBookByAuthor(any())).thenReturn(bookList);

        authorService.getTotalBooks(AUTHOT_JK_ROWLING);

        verify(mockedBookValidatorServiceForHPBooks,times(bookList.size())).isValid(any());
    }

}

