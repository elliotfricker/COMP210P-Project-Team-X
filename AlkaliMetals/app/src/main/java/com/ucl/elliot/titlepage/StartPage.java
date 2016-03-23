package com.ucl.elliot.titlepage;

//Here we are importing the methods required for the start page of the Alkali Metals application

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

//The AppCompatActivity class is used as a base class for activities that use the support library
// action bar.

public class StartPage extends AppCompatActivity {


    //Through calling the super.onCreate(savedInstanceState) it runs the code in addition to the
    //existing code in the onCreate() of the parent class. The onCreate(Bundle) initializes our
    //activity. Here, we call the setContentView(int) which creates a window where we can place
    //our User Interphase and using the findViewById(int), the widgets in that User Interphase
    //are retrieved.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //This has been used to set up the toolbar at the top of the page and include the
        //"Welcome" title within the toolbar as well.

        Toolbar mActionBarToolbar;
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Welcome");

        //The "Tap to Search" button has been set up using an on click listener that waits for a
        // click and has an intent which takes the user from the initial start page activity to
        // the search page activity which is the second page of the application.

        Button startbutton = (Button) findViewById(R.id.MainSearchButton);
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPage.this, SearchPage.class);
                startActivity(intent);

            }
        });
    }

}
