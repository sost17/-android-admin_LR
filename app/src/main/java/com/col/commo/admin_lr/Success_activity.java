package com.col.commo.admin_lr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by commo on 2017/3/17.
 */

public class Success_activity extends Activity{

    private ImageView i1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        i1 = (ImageView) findViewById(R.id.imageView4);

        i1.setImageResource(R.mipmap.im1);


    }
}
