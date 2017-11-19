package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ReadBookActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        ImageView toHomeScreen = findViewById(R.id.readScreenGoBackButton);
        toHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toMoreScreen = findViewById(R.id.readScreenMoreButton);
        toMoreScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MoreScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toLibraryScreen = findViewById(R.id.readScreenLibraryButton);
        toLibraryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LibraryActivity.class);
                startActivity(intent);
            }
        });

        ImageView toScheduleScreen = findViewById(R.id.readScreenScheduleButton);
        toScheduleScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        ImageView toStatsScreen = findViewById(R.id.readScreenStatsButton);
        toStatsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatsActivity.class);
                startActivity(intent);
            }
        });
    }
}
