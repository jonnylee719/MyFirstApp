package com.simplea.jonnylee.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {
    ArticleFragment firstFragment;
    String receivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //adding and removing fragment using fragment manager
        if(findViewById(R.id.fragment_container) != null){
            //if savedInstanceState equals to null then it means it's restoring previous state already so no need to add additional fragments
            if(savedInstanceState != null){
                return;
            }

            firstFragment = new ArticleFragment();

            firstFragment.setArguments(getIntent().getExtras());
            receivedMessage = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        TextView viewMessage = firstFragment.getTextView();
        viewMessage.setText(receivedMessage);
        viewMessage.setTextSize(40);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
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
