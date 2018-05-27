package com.example.sweetseedsapp.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sweetseedsapp.R;
import com.example.sweetseedsapp.controllersandviews.DragListener;
import com.example.sweetseedsapp.controllersandviews.LongPressListener;
import com.example.sweetseedsapp.models.LogicalModel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogicalActivity extends AppCompatActivity {

    private static final String TAG = "LogicalActivity";
    private static LogicalModel logicalModel;
    private static GridLayout mGrid;

    //Views for stones and clubs or "X" and "O".
    private static ImageView stone1;
    private static ImageView stone2;
    private static ImageView stone3;
    private static ImageView stone4;
    private static ImageView stone5;
    private static ImageView club1;
    private static ImageView club2;
    private static ImageView club3;
    private static ImageView club4;
    private static ImageView club5;

    //View and type text for round text at the top.
    private static TextView round_text;
    Typeface typeface;

    //For the textViews inside of the boardViews.
    private static String[] boardNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    private static int[] boardViews = {R.id.image_tv1, R.id.image_tv2, R.id.image_tv3, R.id.image_tv4, R.id.image_tv5, R.id.image_tv6, R.id.image_tv7, R.id.image_tv8, R.id.image_tv9};

    //Used for determining if the game is over
    private static int[][] possibleWinningCombo = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {6, 4, 2}};

    //To pass in game pieces as one data structure
    private static int[] gamePieces = {R.id.stone1, R.id.stone2, R.id.stone3, R.id.stone4, R.id.stone5, R.id.club1, R.id.club2, R.id.club3, R.id.club4, R.id.club5};

    private static int currentState;  // the current state of the game
    private static String currentPlayer; // the current player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical);

        //To set the text type.
        typeface = Typeface.createFromAsset(getAssets(), "fonts/edo.ttf");

        //Setting the views and their drag and drop.
        stone1 = findViewById(R.id.stone1);
        stone1.setOnLongClickListener(new LongPressListener());
        stone1.setOnDragListener(new DragListener());


        stone2 = findViewById(R.id.stone2);
        stone2.setOnLongClickListener(new LongPressListener());
        stone2.setOnDragListener(new DragListener());

        stone3 = findViewById(R.id.stone3);
        stone3.setOnLongClickListener(new LongPressListener());
        stone3.setOnDragListener(new DragListener());


        stone4 = findViewById(R.id.stone4);
        stone4.setOnLongClickListener(new LongPressListener());
        stone4.setOnDragListener(new DragListener());


        stone5 = findViewById(R.id.stone5);
        stone5.setOnLongClickListener(new LongPressListener());
        stone5.setOnDragListener(new DragListener());

        club1 = findViewById(R.id.club1);
        club1.setOnLongClickListener(new LongPressListener());
        club1.setOnDragListener(new DragListener());


        club2 = findViewById(R.id.club2);
        club2.setOnLongClickListener(new LongPressListener());
        club2.setOnDragListener(new DragListener());

        club3 = findViewById(R.id.club3);
        club3.setOnLongClickListener(new LongPressListener());
        club3.setOnDragListener(new DragListener());

        club4 = findViewById(R.id.club4);
        club4.setOnLongClickListener(new LongPressListener());
        club4.setOnDragListener(new DragListener());

        club5 = findViewById(R.id.club5);
        club5.setOnLongClickListener(new LongPressListener());
        club5.setOnDragListener(new DragListener());

        round_text = findViewById(R.id.round_text);
        round_text.setTypeface(typeface);

        //Initiate the game by getting the human spot.
        //If the game is not over and it's not a tie, evaluate the board.
        //Repeat if the game is not over.
        initGame();

        do {
            getHumanSpot();
            if (!gameIsOver() && !tie()) {
                evalBoard();
            }
        } while (!gameIsOver() && !tie());
        System.out.print("Game over\n");

    }


    private static void initGame() {
        currentState = 0; // "playing" or ready to play
        currentPlayer = "X";  // cross plays first
        Log.d(TAG, "initGame: " + currentPlayer + currentState);
    }

    private static String nextPlayer() {
        if (currentPlayer.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

    //getHumanSpot() becomes onTouch and onDrag listeners for the drag and drop motion.
    private static void getHumanSpot() {
        boolean validInput = false;  // for input validation
        round_text.setText("Drag and Drop:\n");
        do {
            int i = 0;
            if (Integer.parseInt(boardNumbers[i]) != gamePieces[i]) {
                boardNumbers[i] = String.valueOf(gamePieces[i]);  // update game-board content
                validInput = true;  // input okay, exit loop
            }
            currentPlayer = nextPlayer();  // sticks play first
        } while (!validInput);  // repeat until input is valid
        Log.d(TAG, "getHumanSpot: ran, current player is next player");

    }

    private static void evalBoard() {
        boolean foundSpot;
        do {
            if (boardNumbers[4].equals("4")) {
                boardNumbers[4] = "O";
                foundSpot = true;
            } else {
                int spot = getBestMove();
                if (spot != -1 && (!boardNumbers[spot].equals("X") && !boardNumbers[spot].equals("O"))) {
                    foundSpot = true;
                    boardNumbers[spot] = "O";
                } else {
                    foundSpot = false;
                }
            }
        } while (!foundSpot);
    }

    private static boolean gameIsOver() {
        //When the currentState is 9 or the same length of the boardNumbers.
        return boardNumbers[0].equals(boardNumbers[1]) && boardNumbers[1].equals(boardNumbers[2]) ||
                boardNumbers[3].equals(boardNumbers[4]) && boardNumbers[4].equals(boardNumbers[5]) ||
                boardNumbers[6].equals(boardNumbers[7]) && boardNumbers[7].equals(boardNumbers[8]) ||
                boardNumbers[0].equals(boardNumbers[3]) && boardNumbers[3].equals(boardNumbers[6]) ||
                boardNumbers[1].equals(boardNumbers[4]) && boardNumbers[4].equals(boardNumbers[7]) ||
                boardNumbers[2].equals(boardNumbers[5]) && boardNumbers[5].equals(boardNumbers[8]) ||
                boardNumbers[0].equals(boardNumbers[4]) && boardNumbers[4].equals(boardNumbers[8]) ||
                boardNumbers[2].equals(boardNumbers[4]) && boardNumbers[4].equals(boardNumbers[6]);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static int getBestMove() {
        ArrayList<String> availableSpaces = new ArrayList<>();
        boolean foundBestMove = false;
        int spot = 100;
        for (String s : boardNumbers) {
            if (!s.equals("X") && !s.equals("O")) {
                availableSpaces.add(s);
            }
        }
        for (String as : availableSpaces) {
            spot = Integer.parseInt(as);
            boardNumbers[spot] = "O";
            if (gameIsOver()) {
                foundBestMove = true;
                boardNumbers[spot] = as;
                return spot;
            } else {
                boardNumbers[spot] = "X";
                if (gameIsOver()) {
                    foundBestMove = true;
                    boardNumbers[spot] = as;
                    return spot;
                } else {
                    boardNumbers[spot] = as;
                }
            }
        }
        if (foundBestMove) {
            round_text.setText(availableSpaces.size());
            return spot;
        } else {
            return ThreadLocalRandom.current().nextInt(0, availableSpaces.size() + 1);
        }
    }


    private static boolean tie() {
        //If there are no more available spaces on the boardNumbers and we've reached gameIsOver(), it's a tie.
        if (currentState == boardNumbers.length) {
            round_text.setText(R.string.tie);
            return true;
        }
        return false;
    }

}
