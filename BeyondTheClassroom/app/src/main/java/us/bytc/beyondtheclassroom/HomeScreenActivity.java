package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreenActivity extends AppCompatActivity implements LoadImageTask.Listener {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        showBook();

        ImageView toLibraryScreen = findViewById(R.id.homeScreenLibraryButton);
        toLibraryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LibraryActivity.class);
                startActivity(intent);
            }
        });

        ImageView toMoreScreen = findViewById(R.id.homeScreenMoreButton);
        toMoreScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MoreScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toReadScreen = findViewById(R.id.homeScreenReadButton);
        toReadScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReadBookActivity.class);
                startActivity(intent);
            }
        });

        ImageView toScheduleScreen = findViewById(R.id.homeScreenScheduleButton);
        toScheduleScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        ImageView toStatsScreen = findViewById(R.id.homeScreenStatsButton);
        toStatsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatsActivity.class);
                startActivity(intent);
            }
        });

    }

    // populate book details to view
    public void showBook() {
        TextView lexileLevelTextView = findViewById(R.id.lexileLevelTextView);
        lexileLevelTextView.setText(R.string.currentBookLexileLevel);

        new LoadImageTask(this).execute(
                "http://books.google.com/books/content?id=84A2AQAAMAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api");

        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(R.string.currentBookTitle);

        TextView authorTextView = findViewById(R.id.authorTextView);
        authorTextView.setText(R.string.currentBookAuthor);

        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(R.string.currentBookDescription);
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        ImageView bookCoverImageView = findViewById(R.id.cardBookCoverImageView);
        bookCoverImageView.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Problem Loading Book Cover Art !", Toast.LENGTH_SHORT).show();
    }
}
