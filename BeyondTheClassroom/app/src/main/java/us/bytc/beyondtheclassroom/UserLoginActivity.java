package us.bytc.beyondtheclassroom;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Context;

public class UserLoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
//    private final FirebaseUser mUser = auth.getCurrentUser();


    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        BookLib lib = new BookLib();
        for(book : lib.Get_books()) {
            Log.d("BOOKS","Book Search Results:\n" + book);
        }

        auth = FirebaseAuth.getInstance();

        //switch view when login is detected
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    if(auth.getCurrentUser().getProviderId() == "parent")
                        startActivity(new Intent(mContext, ParentHomeScreen.class));
                    UserLoginActivity.this.finish();
                }
            }
        };


        Button userLoginButton = findViewById(R.id.userLoginButton);
        userLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        Button createNewUserAccountButton = findViewById(R.id.createNewUserAccountButton);
        createNewUserAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserLoginActivity.this, CreateAccountOptionsActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        auth.addAuthStateListener(authListener);
    }

    //gets user input from view
    private void signIn() {

        EditText loginUserNameEditText = findViewById(R.id.loginUserNameEditText);
        EditText loginPasswordEditText = findViewById(R.id.loginPasswordEditText);
        String username = loginUserNameEditText.getText().toString().trim();
        String password = loginPasswordEditText.getText().toString().trim();

        //make sure a username and password were entered
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {

            Toast.makeText(UserLoginActivity.this, "Please enter a username and password",Toast.LENGTH_LONG).show();

        } else {

            //use firebase authentication to login
            auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(UserLoginActivity.this, "Unable to Login",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
