package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MoreScreenActivity extends AppCompatActivity {

    private Context mContext = this;

    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_screen);

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.signOut();

                Intent intent = new Intent(mContext, UserLoginActivity.class);
                startActivity(intent);
            }
        });

        ImageView goBackButton = findViewById(R.id.moreScreenBackButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

        ImageView toLibraryScreen = findViewById(R.id.moreScreenLibraryButton);
        toLibraryScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LibraryActivity.class);
                startActivity(intent);
            }
        });

        ImageView toReadScreen = findViewById(R.id.moreScreenReadButton);
        toReadScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReadBookActivity.class);
                startActivity(intent);
            }
        });

        ImageView toScheduleScreen = findViewById(R.id.moreScreenScheduleButton);
        toScheduleScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        ImageView toStatsScreen = findViewById(R.id.moreScreenStatsButton);
        toStatsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatsActivity.class);
                startActivity(intent);
            }
        });

    }
}
