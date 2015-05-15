package com.example.yoanncos.applicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {


    private final String EXTRA_LOGIN = "login";
    private final String EXTRA_PASSWORD = "password";

    private EditText login;
    private EditText password;
    private Button connection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (EditText)findViewById(R.id.etLogin);
        password = (EditText)findViewById(R.id.etPass);
        connection = (Button)findViewById(R.id.btnValidate);
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goToNextActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToNextActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(EXTRA_LOGIN, login.getText().toString());
        intent.putExtra(EXTRA_PASSWORD, password.getText().toString());
        startActivity(intent);
    }


}
