package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import us.bytc.beyondtheclassroom.models.Parent;

public class addChildActivity extends AppCompatActivity {

    private String email, password;

    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

    private Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        EditText emailEditText = findViewById(R.id.childEmailEditText);
        EditText passwordEditText = findViewById(R.id.enterPasswordEditText);

        email = emailEditText.getText().toString().trim();
        password = passwordEditText.getText().toString().trim();

        Button registerChildButton = findViewById(R.id.createChildAccountButton);
        registerChildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerUser();

                Intent intent = new Intent(mContext, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser() {

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }


        //creating a new user
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            mDatabaseReference.child(mFirebaseAuth.getCurrentUser().getUid()).child(
                                    "identification").setValue("Child");
                            Toast.makeText(mContext, "Registration Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), HomeScreenActivity.class));
                        } else {
                            //display some message here
                            Toast.makeText(mContext, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}
