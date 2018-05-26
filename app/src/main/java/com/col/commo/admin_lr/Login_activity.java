package com.col.commo.admin_lr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by commo on 2017/3/17.
 */

public class Login_activity extends Activity {

    private EditText user_editText;
    private EditText pwd_editText;
    private TextView textView;
    private Button log_buttun;
    private Button reg_buttun;
    private CheckBox remmber;
    SharedPreferences sp;

    String user1;
    String password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user_editText = (EditText) findViewById(R.id.editText2);
        pwd_editText = (EditText) findViewById(R.id.editText);

        log_buttun = (Button) findViewById(R.id.button2);
        reg_buttun = (Button) findViewById(R.id.button3);

        textView = (TextView) findViewById(R.id.textView12);
        remmber = (CheckBox) findViewById(R.id.checkBox);

        Intent getintent = getIntent();

        final String get_user = getintent.getStringExtra("get_user");
        final String get_password = getintent.getStringExtra("get_passwd");

//        sp = getSharedPreferences("userlist", MODE_PRIVATE);

//        String nameString = sp.getString("username","");
//        String pwdString = sp.getString("pwd","");
//        user_editText.setText(nameString);
//        pwd_editText.setText(pwdString);
//        SharedPreferences.Editor editor = sp.edit();


        log_buttun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_string = user_editText.getText().toString();
                String pwd_string = pwd_editText.getText().toString();

                if( user_string.equals(user1) == true && pwd_string.equals(password1) == true ){

//                    if(remmber.isChecked()){
//                        SharedPreferences.Editor editor = sp.edit();
//                        editor.putString("name",user_string);
//                        editor.putString("password",pwd_string);
//                        editor.commit();
//                    }
                    Intent intent = new Intent();
                    intent.setClass(Login_activity.this,MainActivity.class);

                    intent.putExtra("user",user_string);
                    intent.putExtra("passwd",pwd_string);
                    startActivityForResult(intent,1);
                }else if (user_string.equals("") || pwd_string.equals("")){
                    textView.setText("请输入用户名或密码！！！");
                }else if(user_string.equals(user1) == false){
                    textView.setText("无此用户！！");
                }

                Intent intent = new Intent();
                intent.setClass(Login_activity.this,MainActivity.class);

                intent.putExtra("user",user_string);
                intent.putExtra("passwd",pwd_string);
                startActivityForResult(intent,1);

            }
        });

        reg_buttun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login_activity.this,Register_activity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case RESULT_OK :
                user1 = data.getStringExtra("get_user");
                password1 = data.getStringExtra("get_passwd");

                user_editText.setText(user1);
                pwd_editText.setText(password1);
                textView.setText("");
                break;
            default:
                user_editText.setText("");
                pwd_editText.setText("");
        }
    }
}
