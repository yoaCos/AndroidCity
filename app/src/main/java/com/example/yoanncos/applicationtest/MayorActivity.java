package com.example.yoanncos.applicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.Entity.Mayor;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class MayorActivity extends Activity{

    private final String EXTRA_MAYOR = "Maire";
    private TextView tvName;
    private TextView tvAge;
    private TextView tvCity;
    private TextView tvXP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor);

        Intent intent = getIntent();
        Mayor mayor = intent.getParcelableExtra(EXTRA_MAYOR);

        tvName = (TextView)findViewById(R.id.tvMayorName);
        tvAge = (TextView)findViewById(R.id.tvMayorAge);
        tvCity = (TextView)findViewById(R.id.tvMayorCity);
        tvXP = (TextView)findViewById(R.id.tvMayorXp);

        final String age = String.valueOf(mayor.getAge());
        final String xp = String.valueOf(mayor.getExperience());

        tvName.setText(mayor.getName());
        tvAge.setText(this.getResources().getString(R.string.age_of, age));
        tvCity.setText(this.getResources().getString(R.string.mayor_of, mayor.getCity()));
        tvXP.setText(this.getResources().getString(R.string.experience, xp));

    }
}
