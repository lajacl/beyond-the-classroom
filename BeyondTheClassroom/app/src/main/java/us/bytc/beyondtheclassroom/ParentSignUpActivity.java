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

public class ParentSignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    private Context mContext = this;

   //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button registerParentButton;



    public DatabaseReference databaseReference;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_sign_up);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();



        //initializing views
        editTextEmail = (EditText) findViewById(R.id.parentEmailEditText);
        editTextPassword = (EditText) findViewById(R.id.enterPasswordEditText);

        registerParentButton = (Button) findViewById(R.id.createParentAccountButton);


        databaseReference = FirebaseDatabase.getInstance().getReference();


        //attaching listener to button
        registerParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });    }

    private void registerUser(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }


        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
                            databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child(
                                    "identification").setValue("Parent");
                            Toast.makeText(mContext,"Registration Successful",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), addChildActivity.class));
                        }else{
                            //display some message here
                            Toast.makeText(mContext,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }


}
