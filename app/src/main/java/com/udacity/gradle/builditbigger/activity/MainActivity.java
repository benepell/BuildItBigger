package com.udacity.gradle.builditbigger.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    /*
    public void tellJoke(View view) {

*//*
        Joker joker = new Joker();

        // Show Toast Step 1
        Toast.makeText(this, String.valueOf(joker.getJoke()) , Toast.LENGTH_SHORT).show();

        // Create Intent to launch joke Activity Step 2
        Intent intent = new Intent(this, JokerActivity.class);
        intent.putExtra(JokerActivity.JOKE_KEY, joker.getJoke());
        startActivity(intent);
*//*

        new EndpointAsyncTast().execute(this);
    }
*/

}
