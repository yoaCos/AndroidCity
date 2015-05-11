package com.example.yoanncos.applicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by yoann_000 on 11/05/2015.
 */
public class CityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String s = extras.getString("value");
            TextView view = (TextView)
                    findViewById(R.id.tvCityName);
            view.setText(s);
        }

    }

}
