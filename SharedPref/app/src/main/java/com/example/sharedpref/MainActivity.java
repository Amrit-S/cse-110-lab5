package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button displayButton = (Button) findViewById(R.id.displayButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save();
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display();
            }
        });
    }

    private void save(){
        EditText firstName = (EditText) findViewById(R.id.editFirst);
        EditText lastName = (EditText) findViewById(R.id.editLast);

        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("firstname", firstName.getText().toString());
        editor.putString("lastname", lastName.getText().toString());

        editor.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }

    private void display() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstname", "");
        String lastName = sharedPreferences.getString("lastname", "");
        TextView displayFirstName = (TextView) findViewById(R.id.textView3);
        TextView displayLastName = (TextView) findViewById(R.id.textView4);

        displayFirstName.setText(firstName);
        displayFirstName.setVisibility(View.VISIBLE);
        displayLastName.setText(lastName);
        displayLastName.setVisibility(View.VISIBLE);
    }

}
