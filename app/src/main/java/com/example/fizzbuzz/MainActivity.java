package com.example.fizzbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView fizzbuzz_button, fizz_button, buzz_button, nextNumber_button, startOver_button;
    private TextView currentNumber, gameOverText, fizzbuzz_text;
    private Integer nextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fizz_button = findViewById(R.id.fizz_button);
        fizzbuzz_button = findViewById(R.id.fizzbuzz_button);
        buzz_button = findViewById(R.id.buzz_button);
        nextNumber_button = findViewById(R.id.nextNumber_button);
        startOver_button = findViewById(R.id.startOver_button);
        currentNumber = findViewById(R.id.currentNumber);
        gameOverText = findViewById(R.id.gameOverText);
        fizzbuzz_text = findViewById(R.id.fizzbuzz_text);

        currentNumber.setText("0");

        nextNumber_button.setOnClickListener(click -> {
            if (isDivisbleBy5()) {
                gameOver();
            } else if (isDivisbleBy7()) {
                gameOver();
            } else if (isDivisbleBy5and7()) {
                gameOver();
            } else {
                nextNumber = currentNumberToInteger(getCurrentNumberToString()) + 1;
                currentNumber.setText(String.format("%s", nextNumber));
                fizzbuzz_text.setVisibility(View.INVISIBLE);
            }
        });

        fizz_button.setOnClickListener(click -> {
            if (isDivisbleBy5()) {
                fizzbuzz_text.setVisibility(View.VISIBLE);
                fizzbuzz_text.setText("FIZZ!");
                nextNumber = currentNumberToInteger(getCurrentNumberToString()) + 1;
                currentNumber.setText(String.format("%s", nextNumber));
            } else if (isDivisbleBy7()) {
                gameOver();
            } else if (isDivisbleBy5and7()) {
                gameOver();
            } else {
                gameOver();
            }
        });

        buzz_button.setOnClickListener(click -> {
            if (isDivisbleBy5()) {
                gameOver();
            } else if (isDivisbleBy7()) {
                fizzbuzz_text.setVisibility(View.VISIBLE);
                fizzbuzz_text.setText("BUZZ!");
                nextNumber = currentNumberToInteger(getCurrentNumberToString()) + 1;
                currentNumber.setText(String.format("%s", nextNumber));
            } else if (isDivisbleBy5and7()) {
                gameOver();
            } else {
                gameOver();
            }
        });

        fizzbuzz_button.setOnClickListener(click -> {
            if (isDivisbleBy5()) {
                gameOver();
            } else if (isDivisbleBy7()) {
                gameOver();
            } else if (isDivisbleBy5and7()) {
                fizzbuzz_text.setVisibility(View.VISIBLE);
                fizzbuzz_text.setText("FIZZBUZZ!");
                nextNumber = currentNumberToInteger(getCurrentNumberToString()) + 1;
                currentNumber.setText(String.format("%s", nextNumber));
            } else {
                gameOver();
            }
        });

        startOver_button.setOnClickListener(click -> {
            currentNumber.setVisibility(View.VISIBLE);
            fizzbuzz_text.setVisibility(View.INVISIBLE);
            gameOverText.setVisibility(View.INVISIBLE);
            currentNumber.setText("0");
        });
    }

    private Integer currentNumberToInteger(String current) {
        return Integer.parseInt(current);
    }

    private String getCurrentNumberToString() {
        return currentNumber.getText().toString();
    }

    private void gameOver() {
        currentNumber.setVisibility(View.INVISIBLE);
        fizzbuzz_text.setVisibility(View.INVISIBLE);
        gameOverText.setVisibility(View.VISIBLE);
        gameOverText.setText("GAME OVER");
    }

    private boolean isDivisbleBy5() {
        return (currentNumberToInteger(getCurrentNumberToString()) + 1) % 5 == 0;
    }

    private boolean isDivisbleBy7() {
        return (currentNumberToInteger(getCurrentNumberToString()) + 1) % 7 == 0;
    }

    private boolean isDivisbleBy5and7() {
        return (currentNumberToInteger(getCurrentNumberToString()) + 1) % 5 == 0 && (currentNumberToInteger(getCurrentNumberToString()) + 1) % 7 == 0;
    }
}
