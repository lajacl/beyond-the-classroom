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

        return bookList;
    }

    //then populate myListItems
    public void showBooks(ArrayList<Book> bookList) {
        BookAdapter bookAdapter = new BookAdapter(LibraryActivity.this, R.layout.library_book_card, bookList);

        ListView libraryListView = findViewById(R.id.libraryListView);
        libraryListView.setAdapter(bookAdapter);}
}
