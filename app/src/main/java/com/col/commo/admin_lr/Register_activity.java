package com.col.commo.admin_lr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by commo on 2017/3/17.
 */

public class Register_activity extends Activity {

    private EditText user_editText;
    private EditText pwd_editText;
    private EditText again_pwd_editText;
    private Button success_buttun;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        user_editText = (EditText) findViewById(R.id.editText4);
        pwd_editText = (EditText) findViewById(R.id.editText3);
        again_pwd_editText = (EditText) findViewById(R.id.editText5);
        success_buttun = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.textView11);


        success_buttun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_string = user_editText.getText().toString();
                String pwd_string = pwd_editText.getText().toString();
                String againpwd_string = again_pwd_editText.getText().toString();

                if(pwd_string.equals(againpwd_string) != true){
                    textView.setText("两次密码不一致！！！");
                }else if(user_string.equals("")) {
                    textView.setText("请输入用户名！！！");
                }else{
                        Intent intent = new Intent();
                        intent.setClass(Register_activity.this,Login_activity.class);

                        intent.putExtra("get_user",user_string);
                        intent.putExtra("get_passwd",pwd_string);
                        setResult(RESULT_OK,intent);
                        finish();
                }
            }
        });


    }
}
