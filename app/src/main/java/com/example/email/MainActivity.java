package com.example.email;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText emailEditText;
    EditText titleEditText;
    EditText msgEditText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_constraint);
        setContentView(R.layout.activity_main_relative);
        //setContentView(R.layout.activity_main_linear);

        emailEditText = findViewById(R.id.email);
        titleEditText = findViewById(R.id.title);
        msgEditText = findViewById(R.id.msg);
        sendButton = findViewById(R.id.send);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String email = getIntent().getStringExtra("email");
            String title = getIntent().getStringExtra("title");
            String msg = getIntent().getStringExtra("msg");

            emailEditText.setText(email);
            titleEditText.setText(title);
            msgEditText.setText(msg);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == sendButton.getId()) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("email", emailEditText.getText().toString());
            intent.putExtra("title", titleEditText.getText().toString());
            intent.putExtra("msg", msgEditText.getText().toString());
            startActivity(intent);
        }
    }

    //działający kod do wysyłania maili
        /*if (v.getId() == sendButton.getId()) {
            String email = emailEditText.getText().toString();
            String title = titleEditText.getText().toString();
            String msg = msgEditText.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            intent.putExtra(Intent.EXTRA_TEXT, msg);

            intent.setType("message/rfc822");

            startActivity(
                    Intent
                            .createChooser(intent,
                                    "Choose an Email client :"));
        }*/
}