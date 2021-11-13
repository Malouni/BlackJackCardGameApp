package com.example.t00595213.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class change_profile_picture extends AppCompatActivity implements View.OnClickListener {

    ImageButton img1;
    ImageButton img2;
    ImageButton img3;
    ImageButton img4;
    ImageButton img5;
    ImageButton img6;
    ImageButton img7;
    ImageButton img8;
    ImageButton img9;
    ImageButton img10;
    ImageButton img11;
    ImageButton img12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile_picture);

        img1 = (ImageButton) findViewById(R.id.imageButton1);
        img2 = (ImageButton) findViewById(R.id.imageButton2);
        img3 = (ImageButton) findViewById(R.id.imageButton3);
        img4 = (ImageButton) findViewById(R.id.imageButton4);
        img5 = (ImageButton) findViewById(R.id.imageButton5);
        img6 = (ImageButton) findViewById(R.id.imageButton6);
        img7 = (ImageButton) findViewById(R.id.imageButton7);
        img8 = (ImageButton) findViewById(R.id.imageButton8);
        img9 = (ImageButton) findViewById(R.id.imageButton9);
        img10 = (ImageButton) findViewById(R.id.imageButton10);
        img11 = (ImageButton) findViewById(R.id.imageButton11);
        img12 = (ImageButton) findViewById(R.id.imageButton12);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        img10.setOnClickListener(this);
        img11.setOnClickListener(this);
        img12.setOnClickListener(this);


    }


    public void onClick(View v) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        switch (v.getId()) {


            case R.id.imageButton1:

                editor.putInt("Player_Picture", 1);
                editor.commit();
                Intent intent12 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent12);
                break;

            case R.id.imageButton2:

                editor.putInt("Player_Picture", 2);
                editor.commit();
                Intent intent1 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent1);
                break;

            case R.id.imageButton3:

                editor.putInt("Player_Picture", 3);
                editor.commit();
                Intent intent2 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent2);
                break;

            case R.id.imageButton4:

                editor.putInt("Player_Picture", 4);
                editor.commit();
                Intent intent3 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent3);
                break;

            case R.id.imageButton5:

                editor.putInt("Player_Picture", 5);
                editor.commit();
                Intent intent4 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent4);
                break;

            case R.id.imageButton6:

                editor.putInt("Player_Picture", 6);
                editor.commit();
                Intent intent5 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent5);
                break;

            case R.id.imageButton7:

                editor.putInt("Player_Picture", 7);
                editor.commit();
                Intent intent6 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent6);
                break;

            case R.id.imageButton8:

                editor.putInt("Player_Picture", 8);
                editor.commit();
                Intent intent7 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent7);
                break;

            case R.id.imageButton9:

                editor.putInt("Player_Picture", 9);
                editor.commit();
                Intent intent8 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent8);
                break;

            case R.id.imageButton10:

                editor.putInt("Player_Picture", 10);
                editor.commit();
                Intent intent9 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent9);
                break;

            case R.id.imageButton11:

                editor.putInt("Player_Picture", 11);
                editor.commit();
                Intent intent10 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent10);
                break;

            case R.id.imageButton12:

                editor.putInt("Player_Picture", 12);
                editor.commit();
                Intent intent11 = new Intent(change_profile_picture.this, profile_settings.class);
                startActivity(intent11);
                break;


            default:

                break;

        }


    }


}
