package com.example.we4954cp.bluegreenfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private int framentDisplayed = R.id.blue_fragment;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateFragment();


        //Add click (tap) listener to main UI view
        //android.R.content is a built-in reference to the
        //root element of your UI
        View v = findViewById(android.R.id.content);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFragment();
            }
        });

    }

    void updateFragment(){

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //If blue fragment is shown, replace with green

        if (framentDisplayed == R.id.blue_fragment) {
            GreenFragment greenFragment = new GreenFragment();
            ft.replace(android.R.id.content, greenFragment);
            framentDisplayed = R.id.green_fragment;
        }

        //Otherwise, showing green fragment, replace with blue
        else {
            BlueFragment blueFragment = new BlueFragment();
            ft.replace(android.R.id.content, blueFragment);
            framentDisplayed = R.id.blue_fragment;
        }

        ft.commit();  //must call commit to apply changes
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
}
