package com.col.commo.admin_lr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView user_textView;
    private TextView pwd_textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_textView = (TextView) findViewById(R.id.textView);
        pwd_textView = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);

        Intent getintent = getIntent();

        String user = getintent.getStringExtra("user");
        String password = getintent.getStringExtra("passwd");

        user_textView.setText(user);
        pwd_textView.setText(password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Success_activity.class);
                startActivity(intent);
            }
        });

    }
}
