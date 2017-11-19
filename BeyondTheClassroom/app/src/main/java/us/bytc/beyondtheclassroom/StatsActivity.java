package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StatsActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        ImageView toHomeScreen = findViewById(R.id.statsScreenGoHomeButton);
        toHomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toMoreScreen = findViewById(R.id.statsScreenMoreButton);
        toMoreScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MoreScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toLibraryScreen = findViewById(R.id.statsScreenLibraryButton);
        toLibraryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LibraryActivity.class);
                startActivity(intent);
            }
        });

        ImageView toScheduleScreen = findViewById(R.id.statsScreenScheduleButton);
        toScheduleScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        ImageView toReadBookScreen = findViewById(R.id.statsScreenReadButton);
        toReadBookScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReadBookActivity.class);
                startActivity(intent);
            }
        });
    }
}
