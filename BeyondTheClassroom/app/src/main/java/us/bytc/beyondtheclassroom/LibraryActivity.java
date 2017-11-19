package us.bytc.beyondtheclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import us.bytc.beyondtheclassroom.models.Book;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        showBooks(createBookList());
    }

    //create an array of books for the library
    public ArrayList<Book> createBookList() {
        ArrayList<Book> bookList  = new ArrayList();
        //TODO
        Book book = new Book();
        book.setTitle("The Secret Garden");
        book.setAuthor("Frances Hodgson Burnett");
        book.setImageLink("http://books.google.com/books/content?id=84A2AQAAMAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        bookList.add(book);

        Book book2 = new Book();
        book2.setTitle("Bees Like Flowers");
        book2.setAuthor("Rebecca Bielawski");
        book2.setImageLink("http://books.google.com/books/content?id=Y56aCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        bookList.add(book2);

        Book book3 = new Book();
        book3.setTitle("Rootabaga Stories");
        book3.setAuthor("Carl Sandburg");
        book3.setImageLink("http://books.google.com/books/content?id=EEMeAAAAMAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        bookList.add(book3);

        Book book4 = new Book();
        book4.setTitle("The Cricket on the Hearth");
        book4.setAuthor("Charles Dickens");
        book4.setImageLink("http://books.google.com/books/content?id=kykEAAAAQAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");
        bookList.add(book4);

        return bookList;
    }

    //then populate myListItems
    public void showBooks(ArrayList<Book> bookList) {
        BookAdapter bookAdapter = new BookAdapter(LibraryActivity.this, R.layout.library_book_card, bookList);

        ListView libraryListView = findViewById(R.id.libraryListView);
        libraryListView.setAdapter(bookAdapter);}
}
