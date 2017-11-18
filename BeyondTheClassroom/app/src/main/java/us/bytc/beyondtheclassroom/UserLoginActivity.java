package us.bytc.beyondtheclassroom;


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
import android.content.Context;

public class UserLoginActivity extends AppCompatActivity {
    private EditText loginUserNameEditText;
    private EditText loginPasswordEditText;

    private Button userLoginButton;
    private Button createNewUserAccountButton;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;


    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        loginUserNameEditText = (EditText) findViewById(R.id.loginUserNameEditText);
        loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);

        userLoginButton = (Button) findViewById(R.id.userLoginButton);
        createNewUserAccountButton = (Button) findViewById(R.id.createNewUserAccountButton);

        auth = FirebaseAuth.getInstance();

        //switch view when login is detected
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    startActivity(new Intent(UserLoginActivity.this, BTCHomeScreen.class));
                    UserLoginActivity.this.finish();
                }
            }
        };

        userLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

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
        String username = loginUserNameEditText.getText().toString();
        String password = loginPasswordEditText.getText().toString();

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
        Button createAccountButton = findViewById(R.id.createNewUserAccountButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CreateAccountOptionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
