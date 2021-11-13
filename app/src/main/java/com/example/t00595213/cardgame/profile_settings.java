package com.example.t00595213.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/*dasdasdadad

 */

public class profile_settings extends AppCompatActivity implements View.OnClickListener {
    TextView player_name;
    Button start_game;
    ImageButton ProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        player_name = (TextView) findViewById(R.id.editText_Player_Name);
        start_game = (Button) findViewById(R.id.Button_start_game);
        start_game.setOnClickListener(this);
        ProfilePicture = (ImageButton) findViewById(R.id.imageButton);
        ProfilePicture.setOnClickListener(this);


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        int Picture_holder = sharedPreferences.getInt("Player_Picture", 2);

        String Name_Holder = sharedPreferences.getString("Player_Name", "");

        if (Name_Holder != "")
            player_name.setText(Name_Holder);


        if (Picture_holder == 1) {
            ProfilePicture.setImageResource(R.drawable.avatar1);
        } else if (Picture_holder == 2) {
            ProfilePicture.setImageResource(R.drawable.avatar2);
        } else if (Picture_holder == 3) {
            ProfilePicture.setImageResource(R.drawable.avatar3);
        } else if (Picture_holder == 4) {
            ProfilePicture.setImageResource(R.drawable.avatar4);
        } else if (Picture_holder == 5) {
            ProfilePicture.setImageResource(R.drawable.avatar5);
        } else if (Picture_holder == 6) {
            ProfilePicture.setImageResource(R.drawable.avatar6);
        } else if (Picture_holder == 7) {
            ProfilePicture.setImageResource(R.drawable.avatar7);
        } else if (Picture_holder == 8) {
            ProfilePicture.setImageResource(R.drawable.avatar8);
        } else if (Picture_holder == 9) {
            ProfilePicture.setImageResource(R.drawable.avatar9);
        } else if (Picture_holder == 10) {
            ProfilePicture.setImageResource(R.drawable.avatar10);
        } else if (Picture_holder == 11) {
            ProfilePicture.setImageResource(R.drawable.avatar11);
        } else if (Picture_holder == 12) {
            ProfilePicture.setImageResource(R.drawable.avatar12);
        }


    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Button_start_game:
                if (player_name.getText().toString().equals("") || player_name.getText().toString().equals(" ") || player_name.getText().toString().equals(null)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a valid Name", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                } else {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Player_Name", player_name.getText().toString());
                    editor.commit();
                    Intent intent63 = new Intent(profile_settings.this, game_field.class);
                    startActivity(intent63);
                    break;
                }

            case R.id.imageButton:
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Player_Name", player_name.getText().toString());
                editor.commit();
                Intent intent56 = new Intent(profile_settings.this, change_profile_picture.class);
                startActivity(intent56);
                break;


            default:
                break;
        }
    }



}
