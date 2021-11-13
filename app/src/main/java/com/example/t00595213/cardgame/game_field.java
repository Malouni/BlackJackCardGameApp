package com.example.t00595213.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class game_field extends AppCompatActivity implements View.OnClickListener {
    //Plyers variables
    Button start_game, finish_game;
    ImageView profile_picture;
    TextView player_name, Bot_name, hint,WinnerShower,backgroundForWinnerShower;
    String[] cards = new String[36];
    int[] usedCards = new int[5];
    int usedCardIndex, cardsOnTheField;
    Boolean startGame;
    ImageView playerCard1, playerCard2, playerCard3, playerCard4, playerCard5 ,playerCard6;
    Boolean cardChecker1 = false, cardChecker2 = false, cardChecker3 = false, cardChecker4 = false, cardChecker5 = false , cardChecker6;
    int playerScore;
    int ace_choice, amount_of_aces_at_the_beginning;
    String Name_holder;
    String winner;
    int cardIndex;
    String saverIndex;
    int PlayerCardAmount;
    Animation playerACard1,playerACard2,playerACard3,playerACard4,playerACard5,playerACard6;

    //Bots variables
    int botScore, amountOfAces;
    String Bot_name_holder;
    int[] usedBotsCards = new int[6];
    int usedBotsCardIndex, cardsBotsOnTheField;
    ImageView botCard1, botCard2, botCard3, botCard4, botCard5 , botCard6;
    Boolean botsDecisionNotToTakeCard;
    int BotCardAmount;
    Animation botACard1,botACard2,botACard3,botACard4,botACard5,botACard6;
    Boolean cardBotChecker1 = false, cardBotChecker2 = false, cardBotChecker3 = false, cardBotChecker4 = false, cardBotChecker5 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);

        start_game = (Button) findViewById(R.id.button_start_game_field);
        start_game.setOnClickListener(this);
        profile_picture = (ImageView) findViewById(R.id.profile_picture);
        player_name = (TextView) findViewById(R.id.player_name);
        Bot_name = (TextView) findViewById(R.id.bot_name);
        finish_game = (Button) findViewById(R.id.button_finish_game);
        finish_game.setOnClickListener(this);
        hint = (TextView) findViewById(R.id.textViewHint);
        WinnerShower = (TextView) findViewById(R.id.textViewWinnerShower);
        backgroundForWinnerShower  = (TextView) findViewById(R.id.textView_End_Game_Screen);

        WinnerShower.setVisibility(View.INVISIBLE);
        backgroundForWinnerShower.setVisibility(View.INVISIBLE);

        finish_game.setVisibility(View.INVISIBLE);
        hint.setVisibility(View.INVISIBLE);

        cardChecker1 = false;
        cardChecker2 = false;
        cardChecker3 = false;
        cardChecker4 = false;
        cardChecker5 = false;
        cardChecker6 = false;

        cardBotChecker1 = false;
        cardBotChecker2 = false;
        cardBotChecker3 = false;
        cardBotChecker4 = false;
        cardBotChecker5 = false;

        PlayerCardAmount=2;
        BotCardAmount=2;

        winner="";

        playerCard1 = (ImageView) findViewById(R.id.imageFirstCard);
        playerCard2 = (ImageView) findViewById(R.id.imageSecondCard);
        playerCard3 = (ImageView) findViewById(R.id.imageThirdCard);
        playerCard4 = (ImageView) findViewById(R.id.imageFourthCard);
        playerCard5 = (ImageView) findViewById(R.id.imageFifthCard);
        playerCard6 = (ImageView) findViewById(R.id.imageSixCard);
        botCard1 = (ImageView) findViewById(R.id.imageFirstBotCard);
        botCard2 = (ImageView) findViewById(R.id.imageSecondBotCard);
        botCard3 = (ImageView) findViewById(R.id.imageThirdBotCard);
        botCard4 = (ImageView) findViewById(R.id.imageFourthBotCard);
        botCard5 = (ImageView) findViewById(R.id.imageFifthBotCard);
        botCard6 = (ImageView) findViewById(R.id.imageSixBotCard);

        playerACard1= AnimationUtils.loadAnimation(this,R.anim.first_card);
        playerACard2= AnimationUtils.loadAnimation(this,R.anim.second_card);
        playerACard3= AnimationUtils.loadAnimation(this,R.anim.third_card);
        playerACard4= AnimationUtils.loadAnimation(this,R.anim.fourth_card);
        playerACard5= AnimationUtils.loadAnimation(this,R.anim.fifth_card);
        playerACard6= AnimationUtils.loadAnimation(this,R.anim.six_card);

        botACard1= AnimationUtils.loadAnimation(this,R.anim.first_bot_card);
        botACard2= AnimationUtils.loadAnimation(this,R.anim.second_bot_card);
        botACard3= AnimationUtils.loadAnimation(this,R.anim.third_bot_card);
        botACard4= AnimationUtils.loadAnimation(this,R.anim.fourth_bot_card);
        botACard5= AnimationUtils.loadAnimation(this,R.anim.fifth_bot_card);
        botACard6= AnimationUtils.loadAnimation(this,R.anim.six_bot_card);

        ace_choice = 0;
        startGame = true;
        usedCardIndex = 0;
        botScore = 0;
        playerScore = 0;
        amount_of_aces_at_the_beginning = 0;
        cardIndex=2;


        usedBotsCardIndex = 0;
        cardsBotsOnTheField = 0;
        amountOfAces = 0;
        botsDecisionNotToTakeCard = false;

        cardsOnTheField = 1;
        cards[0] = "6 of clubs";
        cards[1] = "6 of diamonds";
        cards[2] = "6 of hearts";
        cards[3] = "6 of spades";
        cards[4] = "7 of clubs";
        cards[5] = "7 of diamonds";
        cards[6] = "7 of hearts";
        cards[7] = "7 of spades";
        cards[8] = "8 of clubs";
        cards[9] = "8 of diamonds";
        cards[10] = "8 of hearts";
        cards[11] = "8 of spades";
        cards[12] = "9 of clubs";
        cards[13] = "9 of diamonds";
        cards[14] = "9 of hearts";
        cards[15] = "9 of spades";
        cards[16] = "10 of clubs";
        cards[17] = "10 of diamonds";
        cards[18] = "10 of hearts";
        cards[19] = "10 of spades";
        cards[20] = "Jack of clubs";
        cards[21] = "Jack of diamonds";
        cards[22] = "Jack of hearts";
        cards[23] = "Jack of spades";
        cards[24] = "Queen of clubs";
        cards[25] = "Queen of diamonds";
        cards[26] = "Queen of hearts";
        cards[27] = "Queen of spades";
        cards[28] = "King of clubs";
        cards[29] = "King of diamonds";
        cards[30] = "King of hearts";
        cards[31] = "King of spades";
        cards[32] = "Ace of clubs";
        cards[33] = "Ace of diamonds";
        cards[34] = "Ace of hearts";
        cards[35] = "Ace of spades";

        usedCards[0] = -1;
        usedCards[1] = -1;
        usedCards[2] = -1;
        usedCards[3] = -1;
        usedCards[4] = -1;


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Bot_name", "Bunny");
        editor.commit();

        int Picture_holder = sharedPreferences.getInt("Player_Picture", 2);
        Name_holder = sharedPreferences.getString("Player_Name", "");
        Bot_name_holder = sharedPreferences.getString("Bot_name", "");
        saverIndex = sharedPreferences.getString("saverIndex","1");
        Bot_name.setText(Bot_name_holder);

        if (Picture_holder == 1) {
            profile_picture.setImageResource(R.drawable.avatar1);
        } else if (Picture_holder == 2) {
            profile_picture.setImageResource(R.drawable.avatar2);
        } else if (Picture_holder == 3) {
            profile_picture.setImageResource(R.drawable.avatar3);
        } else if (Picture_holder == 4) {
            profile_picture.setImageResource(R.drawable.avatar4);
        } else if (Picture_holder == 5) {
            profile_picture.setImageResource(R.drawable.avatar5);
        } else if (Picture_holder == 6) {
            profile_picture.setImageResource(R.drawable.avatar6);
        } else if (Picture_holder == 7) {
            profile_picture.setImageResource(R.drawable.avatar7);
        } else if (Picture_holder == 8) {
            profile_picture.setImageResource(R.drawable.avatar8);
        } else if (Picture_holder == 9) {
            profile_picture.setImageResource(R.drawable.avatar9);
        } else if (Picture_holder == 10) {
            profile_picture.setImageResource(R.drawable.avatar10);
        } else if (Picture_holder == 11) {
            profile_picture.setImageResource(R.drawable.avatar11);
        } else if (Picture_holder == 12) {
            profile_picture.setImageResource(R.drawable.avatar12);
        }

        player_name.setText(Name_holder);


    }


    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.button_start_game_field:

                if (start_game.getText().equals("Start!")) {
                    finish_game.setVisibility(View.VISIBLE);
                    start_game();
                    Ace_checker_Start_Game();
                    bot();
                    imageSetter();
                    point_counter_start_game();
                    playerCard1.startAnimation(playerACard1);
                    playerCard2.startAnimation(playerACard2);

                    if (amount_of_aces_at_the_beginning > 0) {
                        start_game.setText("Count as 1");
                        finish_game.setText("Count as 11");
                    } else {
                        start_game.setText("Take a Card");
                    }

                } else if (start_game.getText().equals("Take a Card")) {
                    continue_game();
                    cardsOnTheField++;
                    Ace_checker_Continue_Game();
                    imageSetter();
                    bot();
                    point_counter();

                    if(PlayerCardAmount==2) {
                        playerCard3.startAnimation(playerACard3);
                        PlayerCardAmount++;
                    }else if(PlayerCardAmount==3){
                        playerCard4.startAnimation(playerACard4);
                        PlayerCardAmount++;

                    }else if(PlayerCardAmount==4){
                        playerCard5.startAnimation(playerACard5);
                        PlayerCardAmount++;
                    }else if(PlayerCardAmount==5) {
                        playerCard6.startAnimation(playerACard6);
                        PlayerCardAmount++;
                    }


                    Log.v("BotScore",String.valueOf(botScore));
                    Log.v("BotScore",String.valueOf(botsDecisionNotToTakeCard));
                    if(playerScore > 21){
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        winner=Bot_name_holder;
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));

                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText(Bot_name_holder+" won, as the you got more than 21 \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        bot_image_setter();


                    }else if(playerScore==21){
                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText("You won, as the you got 21!! Nice:) \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        winner=Name_holder;
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));
                        bot_image_setter();


                    } else if (amount_of_aces_at_the_beginning > 0) {

                    } else
                        cardOnFieldChecker();

                } else if (start_game.getText().equals("Count as 1")) {
                    amount_of_aces_at_the_beginning--;
                    playerScore+=1;
                    if(playerScore > 21){
                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText(Bot_name_holder+" won, as the you got more than 21 \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        winner=Bot_name_holder;
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));
                        bot_image_setter();

                    }else if(playerScore==21){
                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText("You won, as the you got 21!! Nice:) \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        winner=Name_holder;
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));
                        bot_image_setter();


                    }else if (amount_of_aces_at_the_beginning > 0) {

                    }  else {
                        hint.setVisibility(View.INVISIBLE);
                        start_game.setText("Take a Card");
                        finish_game.setText("End Game");
                    }


                } else if(start_game.getText().equals("Play Again")){
                    Intent intent33333 = new Intent(game_field.this, game_field.class);
                    startActivity(intent33333);
                }


                break;



            case R.id.button_finish_game:
                if (finish_game.getText().equals("End Game")) {
                    if(WinnerShower.getVisibility() == View.VISIBLE){
                        bot_image_setter();
                        start_game.setText("Play Again");
                        finish_game.setText("Score Table");
                    }else {
                        compareAndSave();
                        bot_image_setter();
                        start_game.setText("Play Again");
                        finish_game.setText("Score Table");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                    }

                } else if (finish_game.getText().equals("Count as 11")) {
                    amount_of_aces_at_the_beginning--;
                    playerScore+=11;
                    if(playerScore > 21){
                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText(Bot_name_holder+" won, as the you got more than 21 \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        winner=Bot_name_holder;
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));
                        bot_image_setter();


                    }else if(playerScore==21){
                        start_game.setText("Play Again");
                        finish_game.setText("End Game");
                        WinnerShower.setText("You won, as the you got 21!! Nice:) \nPlease make a chose to continue playing or quit");
                        WinnerShower.setVisibility(View.VISIBLE);
                        backgroundForWinnerShower.setVisibility(View.VISIBLE);
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        winner=Name_holder;
                        editor.putString(saverIndex,winner);
                        saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
                        editor.putString("saverIndex",saverIndex);
                        editor.commit();
                        Log.v("won",String.valueOf(winner));
                        bot_image_setter();


                    }else if (amount_of_aces_at_the_beginning > 0) {

                    } else {
                        hint.setVisibility(View.INVISIBLE);
                        start_game.setText("Take a Card");
                        finish_game.setText("End Game");
                    }
                } else if(finish_game.getText().equals("Score Table")){
                    Intent intent55555 = new Intent(game_field.this, score_table.class);
                    startActivity(intent55555);

                }


                break;

            default:

                break;

        }

    }
    

    /*
    This method checks the card that are in hands for aces to apply special conditions at the beginning of the game
    */


    public void Ace_checker_Start_Game() {
        int first_card = 0, second_card = 1;
        if (usedCards[first_card] >= 32 && usedCards[first_card] <= 35) {
            start_game.setText("Count as 1");
            finish_game.setText("Count as 11");
            hint.setVisibility(View.VISIBLE);
            amount_of_aces_at_the_beginning = 1;
        } else if (usedCards[second_card] >= 32 && usedCards[second_card] <= 35) {
            start_game.setText("Count as 1");
            finish_game.setText("Count as 11");
            hint.setVisibility(View.VISIBLE);
            amount_of_aces_at_the_beginning = 1;
        } else if (usedCards[first_card] >= 32 && usedCards[first_card] <= 35 && usedCards[second_card] >= 32 && usedCards[second_card] <= 35) {
            start_game.setText("Count as 1");
            finish_game.setText("Count as 11");
            hint.setVisibility(View.VISIBLE);
            amount_of_aces_at_the_beginning = 2;
        }


    }

    /*
    This method checks the card that are in hands for Aces to apply special conditions during the game
    */

    public void Ace_checker_Continue_Game() {

        if (usedCards[cardsOnTheField] >= 32 && usedCards[cardsOnTheField] <= 35) {
            start_game.setText("Count as 1");
            finish_game.setText("Count as 11");
            hint.setVisibility(View.VISIBLE);
            amount_of_aces_at_the_beginning = 1;

        } else if (usedCards[cardsOnTheField] >= 32 && usedCards[cardsOnTheField] <= 35) {
            start_game.setText("Count as 1");
            finish_game.setText("Count as 11");
            hint.setVisibility(View.VISIBLE);
            amount_of_aces_at_the_beginning = 1;

        }


    }

    /*
    This method checks the amount of cards during the game
    */

    public void cardOnFieldChecker() {
        if (cardsOnTheField == 4) {
            compareAndSave();
            bot_image_setter();
            start_game.setText("Play Again");
            finish_game.setText("Score Table");
            WinnerShower.setVisibility(View.VISIBLE);
            backgroundForWinnerShower.setVisibility(View.VISIBLE);
        } else {

        }
    }

    /*
    This method compare the bot score and player score and than save it in shared preferences for future uses
    */

    public void compareAndSave() {
        if (playerScore == botScore) {
            WinnerShower.setText("The ended with the draw :)\nPlease make a chose to continue playing or quit");
            winner="Draw";
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(saverIndex,winner);
            saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
            editor.putString("saverIndex",saverIndex);
            editor.commit();
            Log.v("won",String.valueOf(winner));
            bot_image_setter();


        } else if (playerScore > botScore && playerScore <= 21) {
            WinnerShower.setText("You won , as you got more points than "+Bot_name_holder+":)\nPlease make a chose to continue playing or quit");
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            winner=Name_holder;
            editor.putString(saverIndex,winner);
            saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
            editor.putString("saverIndex",saverIndex);
            editor.commit();
            Log.v("won",String.valueOf(winner));
            bot_image_setter();


        } else if(botScore > playerScore && botScore <= 21) {
            WinnerShower.setText(Bot_name_holder+" won , as he got more points than you :(\nPlease make a chose to continue playing or quit");
            winner=Bot_name_holder;
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(saverIndex,winner);
            saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
            editor.putString("saverIndex",saverIndex);
            editor.commit();
            Log.v("won",String.valueOf(winner));
            bot_image_setter();

        }

    }

    /*
        This is the core of the bot

    */

    public void bot() {
        if(botScore >21){
            winner=Name_holder;
            start_game.setText("Play Again");
            WinnerShower.setText("You won , as the bot has more than 21 \nPlease make a chose to continue playing or quit");
            WinnerShower.setVisibility(View.VISIBLE);
            backgroundForWinnerShower.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            winner=Name_holder;
            editor.putString(saverIndex,winner);
            saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
            editor.putString("saverIndex",saverIndex);
            editor.commit();
            Log.v("won",String.valueOf(winner));
            bot_image_setter();


        }else if(botScore==21){
            start_game.setText("Play Again");
            finish_game.setText("End Game");
            WinnerShower.setText(Bot_name_holder+" won, as the he got  21 \nPlease make a chose to continue playing or quit");
            WinnerShower.setVisibility(View.VISIBLE);
            backgroundForWinnerShower.setVisibility(View.VISIBLE);
            winner=Bot_name_holder;
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Saver", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(saverIndex,winner);
            saverIndex = String.valueOf(Integer.valueOf(saverIndex)+1);
            editor.putString("saverIndex",saverIndex);
            editor.commit();
            Log.v("won",String.valueOf(winner));
            bot_image_setter();

        }else {

            if (botsDecisionNotToTakeCard) {

            } else {
                if (startGame) {
                    botStartGame();
                } else
                    botContinueGame();
            }
        }


    }
    /*
        This method is the bot Ace check method

    */

    public void Ace_BotChecker() {
        Random card = new Random();
        int cardHolder;
        cardHolder = card.nextInt(2);

        if (botScore >= 11) {
            botScore += 1;
        } else {
            if (cardHolder == 1)
                botScore += 11;
            else
                botScore += 1;
        }

    }

    /*
        This method is the bot Start game method witch gives bot first two cards and apply the animation

    */

    public void botStartGame() {

        Random card = new Random();
        int cardHolder;

        for (int i = 0; i < 2; i++) {
            cardHolder = card.nextInt(36);
            if (cardHolder != usedBotsCards[0] && cardHolder != usedBotsCards[1]) {
                usedBotsCards[usedBotsCardIndex] = cardHolder;

                if (usedCards[usedBotsCardIndex] >= 0 && usedCards[usedBotsCardIndex] <= 3) {
                    botScore += 6;
                }else if (usedCards[usedBotsCardIndex] >= 4 && usedCards[usedBotsCardIndex] <= 7) {
                    botScore += 7;
                }else if (usedCards[usedBotsCardIndex] >= 8 && usedCards[usedBotsCardIndex] <= 11) {
                    botScore += 8;
                }else if (usedCards[usedBotsCardIndex] >= 12 && usedCards[usedBotsCardIndex] <= 15) {
                    botScore += 9;
                }else if (usedCards[usedBotsCardIndex] >= 16 && usedCards[usedBotsCardIndex] <= 19) {
                    botScore += 10;
                }else if (usedCards[usedBotsCardIndex] >= 20 && usedCards[usedBotsCardIndex] <= 23) {
                    botScore += 2;
                }else if (usedCards[usedBotsCardIndex] >= 24 && usedCards[usedBotsCardIndex] <= 27) {
                    botScore += 3;
                }else if (usedCards[usedBotsCardIndex] >= 28 && usedCards[usedBotsCardIndex] <= 31) {
                    botScore += 4;
                }else if (usedCards[usedBotsCardIndex] >= 32 && usedCards[usedBotsCardIndex] <= 35) {
                    Ace_BotChecker();
                }

                usedBotsCardIndex++;
            } else {
                i--;
            }
        }
        botCard1.setImageResource(R.drawable.cardback1);
        botCard2.setImageResource(R.drawable.cardback1);
        botCard1.startAnimation(botACard1);
        botCard2.startAnimation(botACard2);

    }


    /*
        This method is the bot continue game method witch gives bot first cards and checks some conditions and apply the animation for the next card

    */

    public void botContinueGame() {

        Random card = new Random();
        int cardHolder;

        cardHolder = card.nextInt(10);

        if (botScore >= 19) {
            botsDecisionNotToTakeCard = true;
        } else if (cardHolder >= 6 && cardHolder <=9) {
            botsDecisionNotToTakeCard = true;
        } else if (cardHolder <= 5 && cardHolder >= 0) {


            for (int i = 0; i < 1; i++) {
                cardHolder = card.nextInt(36);
                if (cardHolder != usedBotsCards[0] && cardHolder != usedBotsCards[1] && cardHolder != usedBotsCards[2] && cardHolder != usedBotsCards[3] && cardHolder != usedBotsCards[4]) {
                    usedCards[usedBotsCardIndex] = cardHolder;

                    if (usedCards[usedBotsCardIndex] >= 0 && usedCards[usedBotsCardIndex] <= 3) {
                        botScore += 6;
                    }else if (usedCards[usedBotsCardIndex] >= 4 && usedCards[usedBotsCardIndex] <= 7) {
                        botScore += 7;
                    }else if (usedCards[usedBotsCardIndex] >= 8 && usedCards[usedBotsCardIndex] <= 11) {
                        botScore += 8;
                    }else if (usedCards[usedBotsCardIndex] >= 12 && usedCards[usedBotsCardIndex] <= 15) {
                        botScore += 9;
                    }else if (usedCards[usedBotsCardIndex] >= 16 && usedCards[usedBotsCardIndex] <= 19) {
                        botScore += 10;
                    }else if (usedCards[usedBotsCardIndex] >= 20 && usedCards[usedBotsCardIndex] <= 23) {
                        botScore += 2;
                    }else if (usedCards[usedBotsCardIndex] >= 24 && usedCards[usedBotsCardIndex] <= 27) {
                        botScore += 3;
                    }else if (usedCards[usedBotsCardIndex] >= 28 && usedCards[usedBotsCardIndex] <= 31) {
                        botScore += 4;
                    }else if (usedCards[usedBotsCardIndex] >= 32 && usedCards[usedBotsCardIndex] <= 35) {
                        Ace_BotChecker();
                    }

                    usedBotsCardIndex++;
                } else {
                    i--;
                }
            }

            if(BotCardAmount==2) {

                cardBotChecker3 = true;
                botCard3.setImageResource(R.drawable.cardback1);
                botCard3.startAnimation(botACard3);
                BotCardAmount++;
            }else if(BotCardAmount==3) {

                botCard4.setImageResource(R.drawable.cardback1);
                botCard4.startAnimation(botACard4);
                BotCardAmount++;
                cardBotChecker4 = true;
            }else if(BotCardAmount==4) {

                botCard5.setImageResource(R.drawable.cardback1);
                botCard5.startAnimation(botACard5);
                BotCardAmount++;
                cardBotChecker5 = true;
            }

        }


    }

    /*
            This method is the bot card image setter method wich setts the image according to the card that was given to him by random number

        */
    public void bot_image_setter() {

        int i=0;


        if (cards[usedBotsCards[i]].equals(cards[0])) {
            botCard1.setImageResource(R.drawable.sixofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[1])) {
            botCard1.setImageResource(R.drawable.sixofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[2])) {
            botCard1.setImageResource(R.drawable.sixofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[3])) {
            botCard1.setImageResource(R.drawable.sixofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[4])) {
            botCard1.setImageResource(R.drawable.sevenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[5])) {
            botCard1.setImageResource(R.drawable.sevenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[6])) {
            botCard1.setImageResource(R.drawable.sevenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[7])) {
            botCard1.setImageResource(R.drawable.sevenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[8])) {
            botCard1.setImageResource(R.drawable.eightofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[9])) {
            botCard1.setImageResource(R.drawable.eightofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[10])) {
            botCard1.setImageResource(R.drawable.eightofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[11])) {
            botCard1.setImageResource(R.drawable.eightofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[12])) {
            botCard1.setImageResource(R.drawable.nineofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[13])) {
            botCard1.setImageResource(R.drawable.nineofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[14])) {
            botCard1.setImageResource(R.drawable.nineofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[15])) {
            botCard1.setImageResource(R.drawable.nineofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[16])) {
            botCard1.setImageResource(R.drawable.tenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[17])) {
            botCard1.setImageResource(R.drawable.tenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[18])) {
            botCard1.setImageResource(R.drawable.tenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[19])) {
            botCard1.setImageResource(R.drawable.tenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[20])) {
            botCard1.setImageResource(R.drawable.jackofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[21])) {
            botCard1.setImageResource(R.drawable.jackofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[22])) {
            botCard1.setImageResource(R.drawable.jackofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[23])) {
            botCard1.setImageResource(R.drawable.jackofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[24])) {
            botCard1.setImageResource(R.drawable.queenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[25])) {
            botCard1.setImageResource(R.drawable.queenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[26])) {
            botCard1.setImageResource(R.drawable.queenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[27])) {
            botCard1.setImageResource(R.drawable.queenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[28])) {
            botCard1.setImageResource(R.drawable.kingofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[29])) {
            botCard1.setImageResource(R.drawable.kingofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[30])) {
            botCard1.setImageResource(R.drawable.kingofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[31])) {
            botCard1.setImageResource(R.drawable.kingofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[32])) {
            botCard1.setImageResource(R.drawable.aceofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[33])) {
            botCard1.setImageResource(R.drawable.aceofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[34])) {
            botCard1.setImageResource(R.drawable.aceofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[35])) {
            botCard1.setImageResource(R.drawable.aceofspades);
        }

        i++;


        if (cards[usedBotsCards[i]].equals(cards[0])) {
            botCard2.setImageResource(R.drawable.sixofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[1])) {
            botCard2.setImageResource(R.drawable.sixofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[2])) {
            botCard2.setImageResource(R.drawable.sixofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[3])) {
            botCard2.setImageResource(R.drawable.sixofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[4])) {
            botCard2.setImageResource(R.drawable.sevenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[5])) {
            botCard2.setImageResource(R.drawable.sevenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[6])) {
            botCard2.setImageResource(R.drawable.sevenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[7])) {
            botCard2.setImageResource(R.drawable.sevenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[8])) {
            botCard2.setImageResource(R.drawable.eightofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[9])) {
            botCard2.setImageResource(R.drawable.eightofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[10])) {
            botCard2.setImageResource(R.drawable.eightofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[11])) {
            botCard2.setImageResource(R.drawable.eightofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[12])) {
            botCard2.setImageResource(R.drawable.nineofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[13])) {
            botCard2.setImageResource(R.drawable.nineofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[14])) {
            botCard2.setImageResource(R.drawable.nineofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[15])) {
            botCard2.setImageResource(R.drawable.nineofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[16])) {
            botCard2.setImageResource(R.drawable.tenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[17])) {
            botCard2.setImageResource(R.drawable.tenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[18])) {
            botCard2.setImageResource(R.drawable.tenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[19])) {
            botCard2.setImageResource(R.drawable.tenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[20])) {
            botCard2.setImageResource(R.drawable.jackofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[21])) {
            botCard2.setImageResource(R.drawable.jackofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[22])) {
            botCard2.setImageResource(R.drawable.jackofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[23])) {
            botCard2.setImageResource(R.drawable.jackofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[24])) {
            botCard2.setImageResource(R.drawable.queenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[25])) {
            botCard2.setImageResource(R.drawable.queenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[26])) {
            botCard2.setImageResource(R.drawable.queenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[27])) {
            botCard2.setImageResource(R.drawable.queenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[28])) {
            botCard2.setImageResource(R.drawable.kingofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[29])) {
            botCard2.setImageResource(R.drawable.kingofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[30])) {
            botCard2.setImageResource(R.drawable.kingofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[31])) {
            botCard2.setImageResource(R.drawable.kingofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[32])) {
            botCard2.setImageResource(R.drawable.aceofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[33])) {
            botCard2.setImageResource(R.drawable.aceofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[34])) {
            botCard2.setImageResource(R.drawable.aceofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[35])) {
            botCard2.setImageResource(R.drawable.aceofspades);
        }




        if(cardBotChecker3){
            i++;

        if (cards[usedBotsCards[i]].equals(cards[0])) {
            botCard3.setImageResource(R.drawable.sixofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[1])) {
            botCard3.setImageResource(R.drawable.sixofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[2])) {
            botCard3.setImageResource(R.drawable.sixofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[3])) {
            botCard3.setImageResource(R.drawable.sixofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[4])) {
            botCard3.setImageResource(R.drawable.sevenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[5])) {
            botCard3.setImageResource(R.drawable.sevenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[6])) {
            botCard3.setImageResource(R.drawable.sevenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[7])) {
            botCard3.setImageResource(R.drawable.sevenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[8])) {
            botCard3.setImageResource(R.drawable.eightofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[9])) {
            botCard3.setImageResource(R.drawable.eightofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[10])) {
            botCard3.setImageResource(R.drawable.eightofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[11])) {
            botCard3.setImageResource(R.drawable.eightofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[12])) {
            botCard3.setImageResource(R.drawable.nineofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[13])) {
            botCard3.setImageResource(R.drawable.nineofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[14])) {
            botCard3.setImageResource(R.drawable.nineofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[15])) {
            botCard3.setImageResource(R.drawable.nineofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[16])) {
            botCard3.setImageResource(R.drawable.tenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[17])) {
            botCard3.setImageResource(R.drawable.tenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[18])) {
            botCard3.setImageResource(R.drawable.tenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[19])) {
            botCard3.setImageResource(R.drawable.tenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[20])) {
            botCard3.setImageResource(R.drawable.jackofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[21])) {
            botCard3.setImageResource(R.drawable.jackofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[22])) {
            botCard3.setImageResource(R.drawable.jackofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[23])) {
            botCard3.setImageResource(R.drawable.jackofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[24])) {
            botCard3.setImageResource(R.drawable.queenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[25])) {
            botCard3.setImageResource(R.drawable.queenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[26])) {
            botCard3.setImageResource(R.drawable.queenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[27])) {
            botCard3.setImageResource(R.drawable.queenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[28])) {
            botCard3.setImageResource(R.drawable.kingofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[29])) {
            botCard3.setImageResource(R.drawable.kingofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[30])) {
            botCard3.setImageResource(R.drawable.kingofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[31])) {
            botCard3.setImageResource(R.drawable.kingofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[32])) {
            botCard3.setImageResource(R.drawable.aceofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[33])) {
            botCard3.setImageResource(R.drawable.aceofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[34])) {
            botCard3.setImageResource(R.drawable.aceofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[35])) {
            botCard3.setImageResource(R.drawable.aceofspades);
        }



            cardBotChecker3 = false;


    }else if(cardBotChecker4)
    {
        i++;
        if (cards[usedBotsCards[i]].equals(cards[0])) {
            botCard4.setImageResource(R.drawable.sixofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[1])) {
            botCard4.setImageResource(R.drawable.sixofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[2])) {
            botCard4.setImageResource(R.drawable.sixofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[3])) {
            botCard4.setImageResource(R.drawable.sixofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[4])) {
            botCard4.setImageResource(R.drawable.sevenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[5])) {
            botCard4.setImageResource(R.drawable.sevenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[6])) {
            botCard4.setImageResource(R.drawable.sevenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[7])) {
            botCard4.setImageResource(R.drawable.sevenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[8])) {
            botCard4.setImageResource(R.drawable.eightofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[9])) {
            botCard4.setImageResource(R.drawable.eightofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[10])) {
            botCard4.setImageResource(R.drawable.eightofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[11])) {
            botCard4.setImageResource(R.drawable.eightofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[12])) {
            botCard4.setImageResource(R.drawable.nineofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[13])) {
            botCard4.setImageResource(R.drawable.nineofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[14])) {
            botCard4.setImageResource(R.drawable.nineofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[15])) {
            botCard4.setImageResource(R.drawable.nineofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[16])) {
            botCard4.setImageResource(R.drawable.tenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[17])) {
            botCard4.setImageResource(R.drawable.tenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[18])) {
            botCard4.setImageResource(R.drawable.tenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[19])) {
            botCard4.setImageResource(R.drawable.tenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[20])) {
            botCard4.setImageResource(R.drawable.jackofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[21])) {
            botCard4.setImageResource(R.drawable.jackofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[22])) {
            botCard4.setImageResource(R.drawable.jackofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[23])) {
            botCard4.setImageResource(R.drawable.jackofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[24])) {
            botCard4.setImageResource(R.drawable.queenofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[25])) {
            botCard4.setImageResource(R.drawable.queenofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[26])) {
            botCard4.setImageResource(R.drawable.queenofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[27])) {
            botCard4.setImageResource(R.drawable.queenofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[28])) {
            botCard4.setImageResource(R.drawable.kingofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[29])) {
            botCard4.setImageResource(R.drawable.kingofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[30])) {
            botCard4.setImageResource(R.drawable.kingofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[31])) {
            botCard4.setImageResource(R.drawable.kingofspades);
        } else if (cards[usedBotsCards[i]].equals(cards[32])) {
            botCard4.setImageResource(R.drawable.aceofclubs);
        } else if (cards[usedBotsCards[i]].equals(cards[33])) {
            botCard4.setImageResource(R.drawable.aceofdiamonds);
        } else if (cards[usedBotsCards[i]].equals(cards[34])) {
            botCard4.setImageResource(R.drawable.aceofhearts);
        } else if (cards[usedBotsCards[i]].equals(cards[35])) {
            botCard4.setImageResource(R.drawable.aceofspades);
        }


            cardBotChecker4 = false;



    }else if(cardBotChecker5){
            i++;

        if (cards[usedBotsCards[i]].equals(cards[0]))
            botCard5.setImageResource(R.drawable.sixofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[1]))
            botCard5.setImageResource(R.drawable.sixofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[2]))
            botCard5.setImageResource(R.drawable.sixofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[3]))
            botCard5.setImageResource(R.drawable.sixofspades);
        else if (cards[usedBotsCards[i]].equals(cards[4]))
            botCard5.setImageResource(R.drawable.sevenofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[5]))
            botCard5.setImageResource(R.drawable.sevenofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[6]))
            botCard5.setImageResource(R.drawable.sevenofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[7]))
            botCard5.setImageResource(R.drawable.sevenofspades);
        else if (cards[usedBotsCards[i]].equals(cards[8]))
            botCard5.setImageResource(R.drawable.eightofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[9]))
            botCard5.setImageResource(R.drawable.eightofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[10]))
            botCard5.setImageResource(R.drawable.eightofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[11]))
            botCard5.setImageResource(R.drawable.eightofspades);
        else if (cards[usedBotsCards[i]].equals(cards[12]))
            botCard5.setImageResource(R.drawable.nineofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[13]))
            botCard5.setImageResource(R.drawable.nineofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[14]))
            botCard5.setImageResource(R.drawable.nineofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[15]))
            botCard5.setImageResource(R.drawable.nineofspades);
        else if (cards[usedBotsCards[i]].equals(cards[16]))
            botCard5.setImageResource(R.drawable.tenofspades);
        else if (cards[usedBotsCards[i]].equals(cards[17]))
            botCard5.setImageResource(R.drawable.tenofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[18]))
            botCard5.setImageResource(R.drawable.tenofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[19]))
            botCard5.setImageResource(R.drawable.tenofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[20]))
            botCard5.setImageResource(R.drawable.jackofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[21]))
            botCard5.setImageResource(R.drawable.jackofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[22]))
            botCard5.setImageResource(R.drawable.jackofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[23]))
            botCard5.setImageResource(R.drawable.jackofspades);
        else if (cards[usedBotsCards[i]].equals(cards[24]))
            botCard5.setImageResource(R.drawable.queenofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[25]))
            botCard5.setImageResource(R.drawable.queenofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[26]))
            botCard5.setImageResource(R.drawable.queenofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[27]))
            botCard5.setImageResource(R.drawable.queenofspades);
        else if (cards[usedBotsCards[i]].equals(cards[28]))
            botCard5.setImageResource(R.drawable.kingofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[29]))
            botCard5.setImageResource(R.drawable.kingofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[30]))
            botCard5.setImageResource(R.drawable.kingofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[31]))
            botCard5.setImageResource(R.drawable.kingofspades);
        else if (cards[usedBotsCards[i]].equals(cards[32]))
            botCard5.setImageResource(R.drawable.aceofclubs);
        else if (cards[usedBotsCards[i]].equals(cards[33]))
            botCard5.setImageResource(R.drawable.aceofdiamonds);
        else if (cards[usedBotsCards[i]].equals(cards[34]))
            botCard5.setImageResource(R.drawable.aceofhearts);
        else if (cards[usedBotsCards[i]].equals(cards[35]))
            botCard5.setImageResource(R.drawable.aceofspades);


            cardBotChecker5 = false;
    }

}

/*
            This method player methods that count the score of the player at the beginnin gof the game

        */

    public void point_counter_start_game() {

        for(int j=0;j<2;j++) {


            if (usedCards[j] >= 0 && usedCards[j] <= 3) {
                playerScore += 6;
            }else if (usedCards[j] >= 4 && usedCards[j] <= 7) {
                playerScore += 7;
            }else if (usedCards[j] >= 8 && usedCards[j] <= 11) {
                playerScore += 8;
            }else if (usedCards[j] >= 12 && usedCards[j] <= 15) {
                playerScore += 9;
            }else if (usedCards[j] >= 16 && usedCards[j] <= 19) {
                playerScore += 10;
            }else if (usedCards[j] >= 20 && usedCards[j] <= 23) {
                playerScore += 2;
            }else if (usedCards[j] >= 24 && usedCards[j] <= 27) {
                playerScore += 3;
            }else if (usedCards[j] >= 28 && usedCards[j] <= 31) {
                playerScore += 4;
            }else if (usedCards[j] >= 32 && usedCards[j] <= 35) {

            }
            Log.v("PlayerScore",String.valueOf(playerScore));
            Log.v("PlayerScore","card value"+String.valueOf(usedCards[j]));

        }



    }





/*
            This method player methods that count the score of the player during the game

        */

    public void point_counter() {


            if (usedCards[cardIndex] >= 0 && usedCards[cardIndex] <= 3) {
                playerScore += 6;
            }
            else if (usedCards[cardIndex] >= 4 && usedCards[cardIndex] <= 7) {
                playerScore += 7;
            }else if (usedCards[cardIndex] >= 8 && usedCards[cardIndex] <= 11){
                playerScore += 8;
            }
            else if (usedCards[cardIndex] >= 12 && usedCards[cardIndex] <= 15) {
                playerScore += 9;
            }else if (usedCards[cardIndex] >= 16 && usedCards[cardIndex] <= 19) {
                playerScore += 10;
            }else if (usedCards[cardIndex] >= 20 && usedCards[cardIndex] <= 23) {
                playerScore += 2;
            }else if (usedCards[cardIndex] >= 24 && usedCards[cardIndex] <= 27) {
                playerScore += 3;
            }else if (usedCards[cardIndex] >= 28 && usedCards[cardIndex] <= 31) {
                playerScore += 4;
            }else if (usedCards[cardIndex] >= 32 && usedCards[cardIndex] <= 35){

            }
        Log.v("PlayerScore",String.valueOf(playerScore));
        Log.v("PlayerScore","card value"+ String.valueOf(usedCards[cardIndex]));

        cardIndex++;

    }

    /*
                This method player's methods that gives player 2 cards

            */
    public void start_game() {
        Random card = new Random();
        int cardHolder;

        for (int i = 0; i < 2; i++) {
            cardHolder = card.nextInt(36);
                if (cardHolder != usedCards[0] && cardHolder != usedCards[1]) {
                    usedCards[usedCardIndex] = cardHolder;
                    usedCardIndex++;
                } else {
                    i--;
                }
            }

        }



        /*
                This method player's methods that gives player 1 more card if he wishes to take

            */


    public void continue_game() {
        Random card = new Random();
        int cardHolder;

        for (int i = 0; i < 1; i++) {
            cardHolder = card.nextInt(36);
            if (cardHolder != usedCards[0] && cardHolder != usedCards[1] && cardHolder != usedCards[2] && cardHolder != usedCards[3] && cardHolder != usedCards[4]) {
                usedCards[usedCardIndex] = cardHolder;
                usedCardIndex++;
            } else {
                i--;
                }
            }

    }


    /*
                   This method player's methods that setts the image of the card that was givven to him

               */
    public void imageSetter(){
        int i=0;
        if(startGame){

            if(cards[usedCards[i]].equals(cards [0])) {
                playerCard1.setImageResource(R.drawable.sixofclubs);
            }
            else if (cards[usedCards[i]].equals(cards [1])) {
                playerCard1.setImageResource(R.drawable.sixofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [2])) {
                playerCard1.setImageResource(R.drawable.sixofhearts);
            } else if (cards[usedCards[i]].equals(cards [3])) {
                playerCard1.setImageResource(R.drawable.sixofspades);
            } else if (cards[usedCards[i]].equals(cards [4])) {
                playerCard1.setImageResource(R.drawable.sevenofclubs);
            } else if (cards[usedCards[i]].equals(cards [5])) {
                playerCard1.setImageResource(R.drawable.sevenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [6])) {
                playerCard1.setImageResource(R.drawable.sevenofhearts);
            } else if (cards[usedCards[i]].equals(cards [7])) {
                playerCard1.setImageResource(R.drawable.sevenofspades);
            } else if (cards[usedCards[i]].equals(cards [8])) {
                playerCard1.setImageResource(R.drawable.eightofclubs);
            } else if (cards[usedCards[i]].equals(cards [9])) {
                playerCard1.setImageResource(R.drawable.eightofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [10])) {
                playerCard1.setImageResource(R.drawable.eightofhearts);
            } else if (cards[usedCards[i]].equals(cards [11])) {
                playerCard1.setImageResource(R.drawable.eightofspades);
            } else if (cards[usedCards[i]].equals(cards [12])) {
                playerCard1.setImageResource(R.drawable.nineofclubs);
            } else if (cards[usedCards[i]].equals(cards [13])) {
                playerCard1.setImageResource(R.drawable.nineofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [14])) {
                playerCard1.setImageResource(R.drawable.nineofhearts);
            } else if (cards[usedCards[i]].equals(cards [15])) {
                playerCard1.setImageResource(R.drawable.nineofspades);
            } else if (cards[usedCards[i]].equals(cards [16])) {
                playerCard1.setImageResource(R.drawable.tenofspades);
            } else if (cards[usedCards[i]].equals(cards [17])) {
                playerCard1.setImageResource(R.drawable.tenofclubs);
            } else if (cards[usedCards[i]].equals(cards [18])) {
                playerCard1.setImageResource(R.drawable.tenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [19])) {
                playerCard1.setImageResource(R.drawable.tenofhearts);
            } else if (cards[usedCards[i]].equals(cards [20])) {
                playerCard1.setImageResource(R.drawable.jackofclubs);
            } else if (cards[usedCards[i]].equals(cards [21])) {
                playerCard1.setImageResource(R.drawable.jackofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [22])) {
                playerCard1.setImageResource(R.drawable.jackofhearts);
            } else if (cards[usedCards[i]].equals(cards [23])) {
                playerCard1.setImageResource(R.drawable.jackofspades);
            } else if (cards[usedCards[i]].equals(cards [24])) {
                playerCard1.setImageResource(R.drawable.queenofclubs);
            } else if (cards[usedCards[i]].equals(cards [25])) {
                playerCard1.setImageResource(R.drawable.queenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [26])) {
                playerCard1.setImageResource(R.drawable.queenofhearts);
            } else if (cards[usedCards[i]].equals(cards [27])) {
                playerCard1.setImageResource(R.drawable.queenofspades);
            } else if (cards[usedCards[i]].equals(cards [28])) {
                playerCard1.setImageResource(R.drawable.kingofclubs);
            } else if (cards[usedCards[i]].equals(cards [29])) {
                playerCard1.setImageResource(R.drawable.kingofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [30])) {
                playerCard1.setImageResource(R.drawable.kingofhearts);
            } else if (cards[usedCards[i]].equals(cards [31])) {
                playerCard1.setImageResource(R.drawable.kingofspades);
            } else if (cards[usedCards[i]].equals(cards [32])) {
                playerCard1.setImageResource(R.drawable.aceofclubs);
            } else if (cards[usedCards[i]].equals(cards [33])) {
                playerCard1.setImageResource(R.drawable.aceofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [34])) {
                playerCard1.setImageResource(R.drawable.aceofhearts);
            } else if (cards[usedCards[i]].equals(cards [35])) {
                playerCard1.setImageResource(R.drawable.aceofspades);
            }

            i++;


            if(cards[usedCards[i]].equals(cards [0]))
                playerCard2.setImageResource(R.drawable.sixofclubs);
            else if (cards[usedCards[i]].equals(cards [1]))
                playerCard2.setImageResource(R.drawable.sixofdiamonds);
            else if (cards[usedCards[i]].equals(cards [2]))
                playerCard2.setImageResource(R.drawable.sixofhearts);
            else if (cards[usedCards[i]].equals(cards [3]))
                playerCard2.setImageResource(R.drawable.sixofspades);
            else if (cards[usedCards[i]].equals(cards [4]))
                playerCard2.setImageResource(R.drawable.sevenofclubs);
            else if (cards[usedCards[i]].equals(cards [5]))
                playerCard2.setImageResource(R.drawable.sevenofdiamonds);
            else if (cards[usedCards[i]].equals(cards [6]))
                playerCard2.setImageResource(R.drawable.sevenofhearts);
            else if (cards[usedCards[i]].equals(cards [7]))
                playerCard2.setImageResource(R.drawable.sevenofspades);
            else if (cards[usedCards[i]].equals(cards [8]))
                playerCard2.setImageResource(R.drawable.eightofclubs);
            else if (cards[usedCards[i]].equals(cards [9]))
                playerCard2.setImageResource(R.drawable.eightofdiamonds);
            else if (cards[usedCards[i]].equals(cards [10]))
                playerCard2.setImageResource(R.drawable.eightofhearts);
            else if (cards[usedCards[i]].equals(cards [11]))
                playerCard2.setImageResource(R.drawable.eightofspades);
            else if (cards[usedCards[i]].equals(cards [12]))
                playerCard2.setImageResource(R.drawable.nineofclubs);
            else if (cards[usedCards[i]].equals(cards [13]))
                playerCard2.setImageResource(R.drawable.nineofdiamonds);
            else if (cards[usedCards[i]].equals(cards [14]))
                playerCard2.setImageResource(R.drawable.nineofhearts);
            else if (cards[usedCards[i]].equals(cards [15]))
                playerCard2.setImageResource(R.drawable.nineofspades);
            else if (cards[usedCards[i]].equals(cards [16]))
                playerCard2.setImageResource(R.drawable.tenofspades);
            else if (cards[usedCards[i]].equals(cards [17]))
                playerCard2.setImageResource(R.drawable.tenofclubs);
            else if (cards[usedCards[i]].equals(cards [18]))
                playerCard2.setImageResource(R.drawable.tenofdiamonds);
            else if (cards[usedCards[i]].equals(cards [19]))
                playerCard2.setImageResource(R.drawable.tenofhearts);
            else if (cards[usedCards[i]].equals(cards [20]))
                playerCard2.setImageResource(R.drawable.jackofclubs);
            else if (cards[usedCards[i]].equals(cards [21]))
                playerCard2.setImageResource(R.drawable.jackofdiamonds);
            else if (cards[usedCards[i]].equals(cards [22]))
                playerCard2.setImageResource(R.drawable.jackofhearts);
            else if (cards[usedCards[i]].equals(cards [23]))
                playerCard2.setImageResource(R.drawable.jackofspades);
            else if (cards[usedCards[i]].equals(cards [24]))
                playerCard2.setImageResource(R.drawable.queenofclubs);
            else if (cards[usedCards[i]].equals(cards [25]))
                playerCard2.setImageResource(R.drawable.queenofdiamonds);
            else if (cards[usedCards[i]].equals(cards [26]))
                playerCard2.setImageResource(R.drawable.queenofhearts);
            else if (cards[usedCards[i]].equals(cards [27]))
                playerCard2.setImageResource(R.drawable.queenofspades);
            else if (cards[usedCards[i]].equals(cards [28]))
                playerCard2.setImageResource(R.drawable.kingofclubs);
            else if (cards[usedCards[i]].equals(cards [29]))
                playerCard2.setImageResource(R.drawable.kingofdiamonds);
            else if (cards[usedCards[i]].equals(cards [30]))
                playerCard2.setImageResource(R.drawable.kingofhearts);
            else if (cards[usedCards[i]].equals(cards [31]))
                playerCard2.setImageResource(R.drawable.kingofspades);
            else if (cards[usedCards[i]].equals(cards [32]))
                playerCard2.setImageResource(R.drawable.aceofclubs);
            else if (cards[usedCards[i]].equals(cards [33]))
                playerCard2.setImageResource(R.drawable.aceofdiamonds);
            else if (cards[usedCards[i]].equals(cards [34]))
                playerCard2.setImageResource(R.drawable.aceofhearts);
            else if (cards[usedCards[i]].equals(cards [35]))
                playerCard2.setImageResource(R.drawable.aceofspades);







            startGame=false;

        }else if(cardChecker3 == false){
            i=2;

            if(cards[usedCards[i]].equals(cards [0])) {
                playerCard3.setImageResource(R.drawable.sixofclubs);
            } else if (cards[usedCards[i]].equals(cards [1])) {
                playerCard3.setImageResource(R.drawable.sixofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [2])) {
                playerCard3.setImageResource(R.drawable.sixofhearts);
            } else if (cards[usedCards[i]].equals(cards [3])) {
                playerCard3.setImageResource(R.drawable.sixofspades);
            } else if (cards[usedCards[i]].equals(cards [4])) {
                playerCard3.setImageResource(R.drawable.sevenofclubs);
            } else if (cards[usedCards[i]].equals(cards [5])) {
                playerCard3.setImageResource(R.drawable.sevenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [6])) {
                playerCard3.setImageResource(R.drawable.sevenofhearts);
            } else if (cards[usedCards[i]].equals(cards [7])) {
                playerCard3.setImageResource(R.drawable.sevenofspades);
            } else if (cards[usedCards[i]].equals(cards [8])) {
                playerCard3.setImageResource(R.drawable.eightofclubs);
            } else if (cards[usedCards[i]].equals(cards [9])) {
                playerCard3.setImageResource(R.drawable.eightofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [10])) {
                playerCard3.setImageResource(R.drawable.eightofhearts);
            } else if (cards[usedCards[i]].equals(cards [11])) {
                playerCard3.setImageResource(R.drawable.eightofspades);
            } else if (cards[usedCards[i]].equals(cards [12])) {
                playerCard3.setImageResource(R.drawable.nineofclubs);
            } else if (cards[usedCards[i]].equals(cards [13])) {
                playerCard3.setImageResource(R.drawable.nineofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [14])) {
                playerCard3.setImageResource(R.drawable.nineofhearts);
            } else if (cards[usedCards[i]].equals(cards [15])) {
                playerCard3.setImageResource(R.drawable.nineofspades);
            } else if (cards[usedCards[i]].equals(cards [16])) {
                playerCard3.setImageResource(R.drawable.tenofspades);
            } else if (cards[usedCards[i]].equals(cards [17])) {
                playerCard3.setImageResource(R.drawable.tenofclubs);
            } else if (cards[usedCards[i]].equals(cards [18])) {
                playerCard3.setImageResource(R.drawable.tenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [19])) {
                playerCard3.setImageResource(R.drawable.tenofhearts);
            } else if (cards[usedCards[i]].equals(cards [20])) {
                playerCard3.setImageResource(R.drawable.jackofclubs);
            } else if (cards[usedCards[i]].equals(cards [21])) {
                playerCard3.setImageResource(R.drawable.jackofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [22])) {
                playerCard3.setImageResource(R.drawable.jackofhearts);
            } else if (cards[usedCards[i]].equals(cards [23])) {
                playerCard3.setImageResource(R.drawable.jackofspades);
            } else if (cards[usedCards[i]].equals(cards [24])) {
                playerCard3.setImageResource(R.drawable.queenofclubs);
            } else if (cards[usedCards[i]].equals(cards [25])) {
                playerCard3.setImageResource(R.drawable.queenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [26])) {
                playerCard3.setImageResource(R.drawable.queenofhearts);
            } else if (cards[usedCards[i]].equals(cards [27])) {
                playerCard3.setImageResource(R.drawable.queenofspades);
            } else if (cards[usedCards[i]].equals(cards [28])) {
                playerCard3.setImageResource(R.drawable.kingofclubs);
            } else if (cards[usedCards[i]].equals(cards [29])) {
                playerCard3.setImageResource(R.drawable.kingofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [30])) {
                playerCard3.setImageResource(R.drawable.kingofhearts);
            } else if (cards[usedCards[i]].equals(cards [31])) {
                playerCard3.setImageResource(R.drawable.kingofspades);
            } else if (cards[usedCards[i]].equals(cards [32])) {
                playerCard3.setImageResource(R.drawable.aceofclubs);
            } else if (cards[usedCards[i]].equals(cards [33])) {
                playerCard3.setImageResource(R.drawable.aceofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [34])) {
                playerCard3.setImageResource(R.drawable.aceofhearts);
            } else if (cards[usedCards[i]].equals(cards [35])) {
                playerCard3.setImageResource(R.drawable.aceofspades);
            }



            cardChecker3 = true;
        }else if(cardChecker4 == false){
            i=3;

            if(cards[usedCards[i]].equals(cards [0])) {
                playerCard4.setImageResource(R.drawable.sixofclubs);
            } else if (cards[usedCards[i]].equals(cards [1])) {
                playerCard4.setImageResource(R.drawable.sixofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [2])) {
                playerCard4.setImageResource(R.drawable.sixofhearts);
            } else if (cards[usedCards[i]].equals(cards [3])) {
                playerCard4.setImageResource(R.drawable.sixofspades);
            } else if (cards[usedCards[i]].equals(cards [4])) {
                playerCard4.setImageResource(R.drawable.sevenofclubs);
            } else if (cards[usedCards[i]].equals(cards [5])) {
                playerCard4.setImageResource(R.drawable.sevenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [6])) {
                playerCard4.setImageResource(R.drawable.sevenofhearts);
            } else if (cards[usedCards[i]].equals(cards [7])) {
                playerCard4.setImageResource(R.drawable.sevenofspades);
            } else if (cards[usedCards[i]].equals(cards [8])) {
                playerCard4.setImageResource(R.drawable.eightofclubs);
            } else if (cards[usedCards[i]].equals(cards [9])) {
                playerCard4.setImageResource(R.drawable.eightofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [10])) {
                playerCard4.setImageResource(R.drawable.eightofhearts);
            } else if (cards[usedCards[i]].equals(cards [11])) {
                playerCard4.setImageResource(R.drawable.eightofspades);
            } else if (cards[usedCards[i]].equals(cards [12])) {
                playerCard4.setImageResource(R.drawable.nineofclubs);
            } else if (cards[usedCards[i]].equals(cards [13])) {
                playerCard4.setImageResource(R.drawable.nineofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [14])) {
                playerCard4.setImageResource(R.drawable.nineofhearts);
            } else if (cards[usedCards[i]].equals(cards [15])) {
                playerCard4.setImageResource(R.drawable.nineofspades);
            } else if (cards[usedCards[i]].equals(cards [16])) {
                playerCard4.setImageResource(R.drawable.tenofspades);
            } else if (cards[usedCards[i]].equals(cards [17])) {
                playerCard4.setImageResource(R.drawable.tenofclubs);
            } else if (cards[usedCards[i]].equals(cards [18])) {
                playerCard4.setImageResource(R.drawable.tenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [19])) {
                playerCard4.setImageResource(R.drawable.tenofhearts);
            } else if (cards[usedCards[i]].equals(cards [20])) {
                playerCard4.setImageResource(R.drawable.jackofclubs);
            } else if (cards[usedCards[i]].equals(cards [21])) {
                playerCard4.setImageResource(R.drawable.jackofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [22])) {
                playerCard4.setImageResource(R.drawable.jackofhearts);
            } else if (cards[usedCards[i]].equals(cards [23])) {
                playerCard4.setImageResource(R.drawable.jackofspades);
            } else if (cards[usedCards[i]].equals(cards [24])) {
                playerCard4.setImageResource(R.drawable.queenofclubs);
            } else if (cards[usedCards[i]].equals(cards [25])) {
                playerCard4.setImageResource(R.drawable.queenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [26])) {
                playerCard4.setImageResource(R.drawable.queenofhearts);
            } else if (cards[usedCards[i]].equals(cards [27])) {
                playerCard4.setImageResource(R.drawable.queenofspades);
            } else if (cards[usedCards[i]].equals(cards [28])) {
                playerCard4.setImageResource(R.drawable.kingofclubs);
            } else if (cards[usedCards[i]].equals(cards [29])) {
                playerCard4.setImageResource(R.drawable.kingofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [30])) {
                playerCard4.setImageResource(R.drawable.kingofhearts);
            } else if (cards[usedCards[i]].equals(cards [31])) {
                playerCard4.setImageResource(R.drawable.kingofspades);
            } else if (cards[usedCards[i]].equals(cards [32])) {
                playerCard4.setImageResource(R.drawable.aceofclubs);
            } else if (cards[usedCards[i]].equals(cards [33])) {
                playerCard4.setImageResource(R.drawable.aceofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [34])) {
                playerCard4.setImageResource(R.drawable.aceofhearts);
            } else if (cards[usedCards[i]].equals(cards [35])) {
                playerCard4.setImageResource(R.drawable.aceofspades);
            }





            cardChecker4 = true;

        }else if(cardChecker5 == false){
            i=4;

            if(cards[usedCards[i]].equals(cards [0])) {
                playerCard5.setImageResource(R.drawable.sixofclubs);
            } else if (cards[usedCards[i]].equals(cards [1])) {
                playerCard5.setImageResource(R.drawable.sixofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [2])) {
                playerCard5.setImageResource(R.drawable.sixofhearts);
            } else if (cards[usedCards[i]].equals(cards [3])) {
                playerCard5.setImageResource(R.drawable.sixofspades);
            } else if (cards[usedCards[i]].equals(cards [4])) {
                playerCard5.setImageResource(R.drawable.sevenofclubs);
            } else if (cards[usedCards[i]].equals(cards [5])) {
                playerCard5.setImageResource(R.drawable.sevenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [6])) {
                playerCard5.setImageResource(R.drawable.sevenofhearts);
            } else if (cards[usedCards[i]].equals(cards [7])) {
                playerCard5.setImageResource(R.drawable.sevenofspades);
            } else if (cards[usedCards[i]].equals(cards [8])) {
                playerCard5.setImageResource(R.drawable.eightofclubs);
            } else if (cards[usedCards[i]].equals(cards [9])) {
                playerCard5.setImageResource(R.drawable.eightofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [10])) {
                playerCard5.setImageResource(R.drawable.eightofhearts);
            } else if (cards[usedCards[i]].equals(cards [11])) {
                playerCard5.setImageResource(R.drawable.eightofspades);
            } else if (cards[usedCards[i]].equals(cards [12])) {
                playerCard5.setImageResource(R.drawable.nineofclubs);
            } else if (cards[usedCards[i]].equals(cards [13])) {
                playerCard5.setImageResource(R.drawable.nineofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [14])) {
                playerCard5.setImageResource(R.drawable.nineofhearts);
            } else if (cards[usedCards[i]].equals(cards [15])) {
                playerCard5.setImageResource(R.drawable.nineofspades);
            } else if (cards[usedCards[i]].equals(cards [16])) {
                playerCard5.setImageResource(R.drawable.tenofspades);
            } else if (cards[usedCards[i]].equals(cards [17])) {
                playerCard5.setImageResource(R.drawable.tenofclubs);
            } else if (cards[usedCards[i]].equals(cards [18])) {
                playerCard5.setImageResource(R.drawable.tenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [19])) {
                playerCard5.setImageResource(R.drawable.tenofhearts);
            } else if (cards[usedCards[i]].equals(cards [20])) {
                playerCard5.setImageResource(R.drawable.jackofclubs);
            } else if (cards[usedCards[i]].equals(cards [21])) {
                playerCard5.setImageResource(R.drawable.jackofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [22])) {
                playerCard5.setImageResource(R.drawable.jackofhearts);
            } else if (cards[usedCards[i]].equals(cards [23])) {
                playerCard5.setImageResource(R.drawable.jackofspades);
            } else if (cards[usedCards[i]].equals(cards [24])) {
                playerCard5.setImageResource(R.drawable.queenofclubs);
            } else if (cards[usedCards[i]].equals(cards [25])) {
                playerCard5.setImageResource(R.drawable.queenofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [26])) {
                playerCard5.setImageResource(R.drawable.queenofhearts);
            } else if (cards[usedCards[i]].equals(cards [27])) {
                playerCard5.setImageResource(R.drawable.queenofspades);
            } else if (cards[usedCards[i]].equals(cards [28])) {
                playerCard5.setImageResource(R.drawable.kingofclubs);
            } else if (cards[usedCards[i]].equals(cards [29])) {
                playerCard5.setImageResource(R.drawable.kingofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [30])) {
                playerCard5.setImageResource(R.drawable.kingofhearts);
            } else if (cards[usedCards[i]].equals(cards [31])) {
                playerCard5.setImageResource(R.drawable.kingofspades);
            } else if (cards[usedCards[i]].equals(cards [32])) {
                playerCard5.setImageResource(R.drawable.aceofclubs);
            } else if (cards[usedCards[i]].equals(cards [33])) {
                playerCard5.setImageResource(R.drawable.aceofdiamonds);
            } else if (cards[usedCards[i]].equals(cards [34])) {
                playerCard5.setImageResource(R.drawable.aceofhearts);
            } else if (cards[usedCards[i]].equals(cards [35])) {
                playerCard5.setImageResource(R.drawable.aceofspades);
            }

            cardChecker5 = true;
        }




    }










}
