package com.nancy.alc_40;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 private Button profileButton,aboutButton;
 private Toolbar mainToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profileButton=(Button) findViewById(R.id.main_profile_btn);
        aboutButton=(Button) findViewById(R.id.main_about_btn);
        mainToolBar=(Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolBar);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,profile.class);
                startActivity(intent);
            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,about.class);
                startActivity(intent);
            }
        });
    }
}
