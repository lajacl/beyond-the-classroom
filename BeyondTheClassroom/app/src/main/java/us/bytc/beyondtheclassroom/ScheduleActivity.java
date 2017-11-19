package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ScheduleActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ImageView toHomeScreen = findViewById(R.id.scheduleScreenGoBackButton);
        toHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toMoreScreen = findViewById(R.id.scheduleScreenMoreButton);
        toMoreScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MoreScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toReadScreen = findViewById(R.id.scheduleScreenReadButton);
        toReadScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReadBookActivity.class);
                startActivity(intent);
            }
        });

        ImageView toLibraryScreen = findViewById(R.id.scheduleScreenLibraryButton);
        toLibraryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LibraryActivity.class);
                startActivity(intent);
            }
        });

        ImageView toStatsScreen = findViewById(R.id.scheduleScreenStatsButton);
        toStatsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatsActivity.class);
                startActivity(intent);
            }
        });

    }
}
