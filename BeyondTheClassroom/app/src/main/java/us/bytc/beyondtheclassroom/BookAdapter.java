package us.bytc.beyondtheclassroom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import us.bytc.beyondtheclassroom.models.Book;

/**
 * Created by LaVette_2 on 11/19/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    private Activity activity;
    private ArrayList<Book> bookList;
    private static LayoutInflater inflater = null;

    public BookAdapter(Activity activity, int textViewResourceId, ArrayList<Book> bookArrayList) {
        super(activity, textViewResourceId, bookArrayList);
        try {
            this.activity = activity;
            this.bookList = bookArrayList;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return bookList.size();
    }

    public Book getItem(Book position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView cardLabelTextView;
        public TextView cardTitleTextView;
        public TextView cardAuthorTextView;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                view = inflater.inflate(R.layout.activity_library, null);
                holder = new ViewHolder();

                holder.cardLabelTextView = (TextView) view.findViewById(R.id.cardLabelTextView);
                holder.cardTitleTextView = (TextView) view.findViewById(R.id.cardTitleTextView);
                holder.cardAuthorTextView = (TextView) view.findViewById(R.id.cardAuthorTextView);


                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }



            if (position == 0) {
                holder.cardLabelTextView.setText(R.string.currentBookLabel);
            }
            holder.cardTitleTextView.setText(bookList.get(position).getTitle());
            holder.cardAuthorTextView.setText(bookList.get(position).getAuthor());


        } catch (Exception e) {


        }
        return view;
    }
}
