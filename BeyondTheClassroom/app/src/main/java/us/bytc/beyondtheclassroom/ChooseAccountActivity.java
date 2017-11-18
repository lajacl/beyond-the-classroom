package us.bytc.beyondtheclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseAccountActivity extends AppCompatActivity {

    private Button parentBtn;
    private Button teacherBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);

        parentBtn = (Button) findViewById(R.id.btnParent);
        teacherBtn = (Button) findViewById(R.id.btnTeacher);

        parentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseAccountActivity.this, ParentSignUpActivity.class));
            }
        });

        teacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseAccountActivity.this, TeacherSignUpActivity.class));
            }
        });
    }
}
