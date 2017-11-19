package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LottieAnimation extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animation);

        Handler h = new Handler();
        h.postDelayed(r, 1000);
    }

    Runnable r = new Runnable() {
        @Override
        public void run(){
            Intent intent = new Intent(mContext, HomeScreenActivity.class);
            startActivity(intent); //<-- put your code in here.
        }
    };
}
