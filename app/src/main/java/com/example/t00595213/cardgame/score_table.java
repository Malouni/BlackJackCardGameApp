package com.example.t00595213.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class score_table extends AppCompatActivity implements View.OnClickListener {
    ListView gameHis;
    Button mainmenu;
    String [] list;
    int array_capacity=0;
    int i=0;
    ListView lv;
    String winner_holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);
        mainmenu = (Button) findViewById(R.id.buttonMainMenu);
        mainmenu.setOnClickListener(this);


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        String index_holder = "1";
        winner_holder=sharedPreferences.getString(index_holder,"-1");
        Log.v("Winner",winner_holder);


        while(!winner_holder.equals("-1")){
            array_capacity++;
            index_holder=String.valueOf(Integer.valueOf(index_holder)+1);
            winner_holder=sharedPreferences.getString(index_holder,"-1");

        }

        index_holder= "1";
        winner_holder = sharedPreferences.getString(index_holder,"-1");

        if(winner_holder.equals("-1")){
            list = new String [1];
            list[i]="";






        }else{

            list = new String [array_capacity];


            while(i<list.length){

                if(winner_holder.equals("Bunny")) {
                    list[i] = "Bunny VS Player : Winner -> " + String.valueOf(winner_holder) + " (Bot)";
                }else if(winner_holder.equals("Draw")){
                    list[i] = "Bunny VS Player : No Winner, it is Draw ";
                }else{
                    list[i] = "Bunny VS Player : Winner -> " + String.valueOf(winner_holder) + " (Player)";
                }
                i++;
                index_holder=String.valueOf(Integer.valueOf(index_holder)+1);
                winner_holder=sharedPreferences.getString(index_holder,"-1");

            }
        }


        lv = (ListView) findViewById(R.id.List_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonMainMenu:
                Intent intent9999 = new Intent(score_table.this, start_screen.class);
                startActivity(intent9999);

                break;

            default:
                break;

        }

        }

}
