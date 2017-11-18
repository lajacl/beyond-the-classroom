import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import android.net.Uri;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ListIterator;


/**
 * Created by Beast on 11/18/2017.
 */

public class BookLib {

    String ApiKey="AIzaSyBfgIz1j9K2gFHYlY_WI-PbXkvyo8i0UXU";
    String url = "https://developers.google.com/books/docs/v1/using";
    final String BOOK_BASE_URL =  "https://www.googleapis.com/books/v1/volumes?";

    final String QUERY_PARAM = "q"; // Parameter for the search string.
    final String MAX_RESULTS = "maxResults"; // Parameter that limits search results.
    final String PRINT_TYPE = "printType"; // Parameter to filter by print type.


public void Search_books(){}

public List<Book> Get_books(){

    List<Book> _books = new ArrayList<Book>();
    List<String> listStrings;// = new ArrayList<String>();


// Attempt to query the Books API.


        // Base URI for the Books API.
        final String BOOK_BASE_URL =  "https://www.googleapis.com/books/v1/volumes?";

        final String QUERY_PARAM = "q"; // Parameter for the search string.
        final String MAX_RESULTS = "maxResults"; // Parameter that limits search results.
        final String PRINT_TYPE = "printType"; // Parameter to filter by print type.

        // Build up your query URI, limiting results to 10 items and printed books.
        Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, "queryString")
                .appendQueryParameter(MAX_RESULTS, "10")
                .appendQueryParameter(PRINT_TYPE, "books")
                .appendQueryParameter(ApiKey, "Key")
                .build();
    try {
        URL requestURL = new URL(builtURI.toString());
        HttpURLConnection con = (HttpURLConnection) requestURL.openConnection();
        // Open the network connection.

        con.setRequestMethod("GET");
        con.connect();

        // Get the InputStream.
        InputStream inputStream = con.getInputStream();

        // Read the response string into a StringBuilder.
        StringBuilder builder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
            // but it does make debugging a *lot* easier if you print out the completed buffer for debugging.
            builder.append(line + "\n");
        }

        if (builder.length() == 0) {
            // Stream was empty.  No point in parsing.
            // return null;
            return null;
        }
        String bookJSONString = builder.toString();
        if (con != null) {
            con.disconnect();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // Catch errors.
    } catch (IOException e) {
        e.printStackTrace();

        // Close the connections.
    } finally {

    }

    return _books;

}

public void Get_books_by_User(){}

public void Get_books_by_age(){}

public List<Book> JSonTOBookObject(String booklist){
    List<Book> _booklist = new ArrayList<Book>();

   // ObjectMapper mapper = new ObjectMapper();
    //JsonNode rootNode = mapper.readTree(booklist);
//    _booklist.add(rootNode);

    return _booklist;
}
}
