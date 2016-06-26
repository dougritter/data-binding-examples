package com.dougritter.databindingexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mLastName;
    private Button mChangeButton;

    private boolean shouldPassNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (TextView) findViewById(R.id.name);
        mLastName = (TextView) findViewById(R.id.lastName);
        mChangeButton = (Button) findViewById(R.id.changeButton);

        setListeners();
    }

    public void updateUI(User user) {
        if (user == null) {
            mName.setText(null);
            mLastName.setText(null);
        } else {
            mName.setText(user.getName());
            mLastName.setText(user.getLastName());
        }

    }

    public void setListeners() {
        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (!shouldPassNull) {
                    User user = new User(getString(R.string.default_user_name),
                            getString(R.string.default_user_lastname));

                    updateUI(user);
                    shouldPassNull = true;
                    Toast.makeText(MainActivity.this, "Passed a valid user", Toast.LENGTH_SHORT).show();

                } else {
                    updateUI(null);
                    shouldPassNull = false;
                    Toast.makeText(MainActivity.this, "Passed a null user", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
