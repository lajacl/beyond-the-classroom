package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeScreenActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ImageView moreButtonImageView = findViewById(R.id.homeScreenMoreButton);
        moreButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MoreScreenActivity.class);
                startActivity(intent);
            }
        });

    }
}