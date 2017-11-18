package us.bytc.beyondtheclassroom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import us.bytc.beyondtheclassroom.models.Parent;

public class ParentSignUpActivity extends AppCompatActivity {
    EditText parentNameEditText =  findViewById(R.id.parentNameEditText);
    EditText parentEmailEditText = findViewById(R.id.parentEmailEditText);
    EditText parentPhoneNumberEditText = findViewById(R.id.parentPhoneNumberEditText);
    EditText enterPasswordEditText = findViewById(R.id.enterPasswordEditText);
    EditText reEnterPasswordEditText = findViewById(R.id.reEnterPasswordEditText);

    String name = parentNameEditText.getText().toString().trim();
    String email = parentEmailEditText.getText().toString().trim();
    String phone = parentPhoneNumberEditText.getText().toString().trim();
    String password1 = enterPasswordEditText.getText().toString().trim();
    String password2 = reEnterPasswordEditText.getText().toString().trim();

    Parent parent = new Parent();

    private FirebaseAuth auth;
    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference("/parents");

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_sign_up);

        auth = FirebaseAuth.getInstance();

        Button registerParentButton = findViewById(R.id.createParentAccountButton);
        registerParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasEmptyFields() && doPasswordsMatch(password1, password2)) {
                    parentSignUp(createParent());
                }
            }
        });

    }

    //adds the parent to the authenticated users
    public void parentSignUp(final Parent parent) {

            auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                String userId = user.getUid();

                                Toast.makeText(ParentSignUpActivity.this, "Your account was created.",
                                Toast.LENGTH_LONG).show();
                            firebaseReference.child(userId).setValue(parent);
                            updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(ParentSignUpActivity.this, "Unable to create account.",
                                        Toast.LENGTH_SHORT).show();
                            updateUI(null);
                            }

                            // ...
                        }
                    });
    }

    //create a parent object to hold the user data entered
    public Parent createParent() {
        parent.setName(name);
        parent.setEmail(email);
        parent.setPhone(phone);

        return parent;
    }

    //check the form for any null values
    public Boolean hasEmptyFields () {
        String[] fields = {name, email, phone, password1, password2};

        for (String field : fields) {
            if (field == null) {
                Toast.makeText(mContext, "All fields must be entered", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    //make sure passwords entered match
    public Boolean doPasswordsMatch(String password1, String password2) {
        if(password1.equals(password2)) {
            return true;
        } else {
            Toast.makeText(mContext, "Passwords do not match", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    //TODO
    //check to validate password
    //Must include at least one capitol letter.
    //Must include at least one number.
    public Boolean isValidPassword(String password) {
        return true;
    }

    public void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent intent = new Intent(mContext, addChildActivity.class);
            startActivity(intent);
        }else {
            //TODO
        }
    }
}
