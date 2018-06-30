/*
package us.bytc.beyondtheclassroom;

*/
/**
 * Created by LaVette_2 on 11/19/2017.
 *//*


public class BookService {

    private static final String API_KEY = "AIzaSyBfgIz1j9K2gFHYlY_WI-PbXkvyo8i0UXU";
    private static final String FETCH_RECENTS_METHOD = "google.books.getRecent";
    private static final String SEARCH_METHOD = "google.books.search";
    private static final Uri ENDPOINT = Uri.parse("https://www.googleapis.com/books/v1/volumes?")
            .buildUpon()
            .appendQueryParameter("api_key", API_KEY)
            .appendQueryParameter("format", "json")
            .appendQueryParameter("nojsoncallback", "1")
            .appendQueryParameter("extras", "url_s,geo")
            .build();



    private void parseItems(List<Book> items, JSONObject jsonBody)
            throws IOException, JSONException {

        JSONArray itemsJsonArray = itemsJsonObject.getJSONArray("items");
        JSONObject titleJsonObject = jsonBody.getJSONObject("title");
        JSONArray authorsJsonArray = authorsJsonObject.getJSONArray("authors");
        JSONObject descriptionJsonObject = jsonBody.getJSONObject("description");
        for (int i = 0; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);
            Booke item = new Book();
            item.setId(photoJsonObject.getString("id"));
            item.setCaption(photoJsonObject.getString("title"));
            if (!photoJsonObject.has("url_s")) {
                continue;
            }
            item.setUrl(photoJsonObject.getString("url_s"));
            item.setLat(photoJsonObject.getDouble("latitude"));
            item.setLon(photoJsonObject.getDouble("longitude"));
            items.add(item);    } }

}
*/
