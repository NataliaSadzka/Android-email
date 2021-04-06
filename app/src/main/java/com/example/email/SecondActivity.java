package com.example.email;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements View.OnClickListener {

    TextView emailTextView;
    TextView titleTextView;
    TextView msgTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        emailTextView = findViewById(R.id.email);
        titleTextView = findViewById(R.id.title);
        msgTextView = findViewById(R.id.msg);
        backButton = findViewById(R.id.back);

        String email = getIntent().getStringExtra("email");
        String title = getIntent().getStringExtra("title");
        String msg = getIntent().getStringExtra("msg");

        emailTextView.setText(email);
        titleTextView.setText(title);
        msgTextView.setText(msg);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == backButton.getId()) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("email", emailTextView.getText().toString());
            intent.putExtra("title", titleTextView.getText().toString());
            intent.putExtra("msg", msgTextView.getText().toString());
        startActivity(intent);
        }
    }
}
