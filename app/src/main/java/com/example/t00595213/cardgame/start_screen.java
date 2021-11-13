package com.example.t00595213.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class start_screen extends AppCompatActivity implements View.OnClickListener {

    Button start, profile_settings, score_table;
    boolean firstTimeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(this);
        profile_settings = (Button) findViewById(R.id.button_profile_settings);
        profile_settings.setOnClickListener(this);
        score_table = (Button) findViewById(R.id.button_score_table);
        score_table.setOnClickListener(this);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        int holder = sharedPreferences.getInt("First_Time", 0);

        if (holder == 1)
            firstTimeUser = false;

        else
            firstTimeUser = true;


    }

    public void onClick(View v) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (v.getId()) {

            case R.id.buttonStart:
                if (firstTimeUser == true) {
                    editor.putInt("First_Time", 1);
                    editor.commit();
                    Intent intent555 = new Intent(start_screen.this, profile_settings.class);
                    startActivity(intent555);

                    break;
                } else {
                    Intent intent = new Intent(start_screen.this, game_field.class);
                    startActivity(intent);
                    break;
                }

            case R.id.button_profile_settings:
                Intent intent100 = new Intent(start_screen.this, profile_settings.class);
                startActivity(intent100);
                break;

            case R.id.button_score_table:
                Intent intent244 = new Intent(start_screen.this, score_table.class);
                startActivity(intent244);
                break;


            default:

                break;
        }


    }




}
