package com.arash.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //0=circle 1=cross
    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2} ;
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameIsActive = true;
    boolean gameIsOver =true;



    @SuppressLint("SetTextI18n")
    public void clickFunction(View view){

        ImageView img16 = (ImageView) findViewById(R.id.imageView16);
        ImageView img17 = (ImageView) findViewById(R.id.imageView17);
        EditText playerTwo = (EditText) findViewById(R.id.txtPlayerTwo);
        EditText playerOne = (EditText) findViewById(R.id.txtPlayerOne);
        playerOne.setFocusable(false);
        playerTwo.setFocusable(false);
        playerOne.setFocusable(true);
        playerTwo.setFocusable(true);
        playerOne.setFocusableInTouchMode(true);
        playerTwo.setFocusableInTouchMode(true);
        ImageView button = (ImageView) view ;
        int tappedButton = Integer.parseInt(button.getTag().toString());
        if(gameState[tappedButton]==2  && gameIsActive ) {
            gameState[tappedButton]=activePlayer;
            gameIsOver=true;
            button.setRotation(0f);
            button.setScaleX(0.5f);
            button.setScaleY(0.5f);
            //button.setTranslationY(-1000);
            if (activePlayer == 0) {
                button.setImageResource(R.drawable.circle);
                activePlayer = 1;
                img16.setImageResource(R.drawable.circle2);
                img17.setImageResource(R.drawable.cross);
            } else {
                button.setImageResource(R.drawable.cross);
                activePlayer = 0;
                img16.setImageResource(R.drawable.circle);
                img17.setImageResource(R.drawable.cross2);
            }
            button.animate().scaleY(1f);
            button.animate().scaleX(1f);
            button.animate().rotation(360f).setDuration(1000);
        }
        for(int[]  winningPositions : winningPositions){
            if(gameState[winningPositions[0]] == gameState[winningPositions[1]] &&
                    gameState[winningPositions[1]] == gameState[winningPositions[2]] &&
                    gameState[winningPositions[0]] != 2 ){

                String winner =playerTwo.getText().toString();
                if (gameState[winningPositions[0]]==0)
                    // winner="Circle";
                    winner=playerOne.getText().toString();


                TextView txtWinner = (TextView) findViewById(R.id.txtWinner);
                txtWinner.setText(winner +"\n Has Won");


                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutContainer);

                linearLayout.setVisibility(View.VISIBLE);
                gameIsActive=false;
                gameIsOver=false;
            }else{

                for (int counterState : gameState){

                    if(counterState==2)
                        gameIsOver=false;

                }




            }

        }if(gameIsOver){
            TextView txtWinner = (TextView) findViewById(R.id.txtWinner);
            txtWinner.setText("Its's a Draw");

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutContainer);

            linearLayout.setVisibility(View.VISIBLE);



        }

    }
    public void playAgainFunction  (View view){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutContainer);


        linearLayout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for(int i=0;i<gameState.length;i++){

            gameState[i]=2;
        }
        gameIsActive=true;

        ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setImageResource(0);
        ImageView img3 = (ImageView) findViewById(R.id.imageView5);
        img3.setImageResource(0);
        ImageView img4 = (ImageView) findViewById(R.id.imageView8);
        img4.setImageResource(0);
        ImageView img5 = (ImageView) findViewById(R.id.imageView3);
        img5.setImageResource(0);
        ImageView img6 = (ImageView) findViewById(R.id.imageView6);
        img6.setImageResource(0);
        ImageView img7 = (ImageView) findViewById(R.id.imageView7);
        img7.setImageResource(0);
        ImageView img8 = (ImageView) findViewById(R.id.imageView9);
        img8.setImageResource(0);
        ImageView img9 = (ImageView) findViewById(R.id.imageView10);
        img9.setImageResource(0);
        ImageView img10 = (ImageView) findViewById(R.id.imageView4);
        img10.setImageResource(0);

        ImageView img16 = (ImageView) findViewById(R.id.imageView16);
        ImageView img17 = (ImageView) findViewById(R.id.imageView17);
        img16.setImageResource(R.drawable.circle);
        img17.setImageResource(R.drawable.cross2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
