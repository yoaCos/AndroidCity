package com.example.yoanncos.applicationtest;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yoanncos.applicationtest.fragments.CityFragment;

/**
 * Created by Yoann.Cos on 04/05/2015.
 */
public class MainActivity extends AppCompatActivity{


    private String[] mMenuSections;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private TextView login;
    private TextView password;

    private final String EXTRA_LOGIN = "login";
    private final String EXTRA_PASSWORD = "password";

    private boolean mDualPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        determinePanelLayout();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


        mMenuSections = getResources().getStringArray(R.array.navigation_drawer);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_left,
                mMenuSections));

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.closed_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.d("CityActivity", "onDrawerClosed");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.d("CityActivity", "onDrawerClosed");
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0 :
                        Intent intent = new Intent(MainActivity.this, BidonActivity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        Intent intent1 = new Intent(MainActivity.this, MayorListActivity.class);
                        startActivity(intent1);
                }
            }
        });

        Intent intent = getIntent();

        if ((login = (TextView)findViewById(R.id.tvWelcome))!=null) {

            String loginTxt = String.format("Bienvenue %s ton mot de passe est %s :D",
                    intent.getStringExtra(EXTRA_LOGIN), intent.getStringExtra(EXTRA_PASSWORD));

            login = (TextView) findViewById(R.id.tvWelcome);
            login.setText(loginTxt);
        }
    }

    private void determinePanelLayout() {
        FrameLayout fragmentDetail = (FrameLayout)findViewById(R.id.frameDetails);
        if (fragmentDetail != null){
            mDualPane = true;
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.frameDetails, new CityFragment());
            ft.commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_city, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_search:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_information:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
 }
}




