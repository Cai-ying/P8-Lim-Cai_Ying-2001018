package my.edu.utar.colourgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level_2 extends AppCompatActivity {

    private Button button;

    private TextView timerTextView;
    private Button btnBgSelector;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private final long startTime = 5000; // 5 seconds
    private final long interval = 1000; // 1 second

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        button = (Button) findViewById(R.id.endGame2);

        //navigate to Bye page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level_2.this,Bye.class);
                startActivity(intent);
            }
        });

        timerTextView = findViewById(R.id.timertextView);
        btnBgSelector = findViewById(R.id.btnBgSelector2);

        //array for all button
        Button[] buttons = new Button[8];
        buttons[0] = (Button)findViewById(R.id.btnBgSelectorDisabled1);
        buttons[1] = (Button)findViewById(R.id.btnBgSelectorDisabled2);
        buttons[2] = (Button)findViewById(R.id.btnBgSelectorDisabled3);
        buttons[3] = (Button)findViewById(R.id.btnBgSelectorDisabled4);
        buttons[4] = (Button)findViewById(R.id.btnBgSelectorDisabled5);
        buttons[5] = (Button)findViewById(R.id.btnBgSelectorDisabled6);
        buttons[6] = (Button)findViewById(R.id.btnBgSelectorDisabled7);
        buttons[7] = (Button)findViewById(R.id.btnBgSelectorDisabled8);

        //timer
        timerRunning = false;

        countDownTimer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Timer: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("Timer: 0");
                navigateToGameOverPage();
            }
        };

        //correct_button -->cancel timer and navigate to level 2 when press the button
        btnBgSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    countDownTimer.cancel();
                    timerRunning = false;
                    navigateToLevel3();
                }
            }
        });

        // for loop for the wrong button, will navigate to game over page
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (timerRunning) {
                        countDownTimer.cancel();
                        timerRunning = false;
                        navigateToGameOverPage();
                    }
                    // Get the TextView
                    TextView textView = findViewById(R.id.score);

                    // Get the text from the TextView
                    String text = textView.getText().toString();
                    // Create an Intent to start game over page
                    Intent intent = new Intent(Level_2.this, gameover2.class);

                    // Add the text as an extra in the Intent
                    intent.putExtra("Score Archieved: ", text);

                    // Start ActivityB
                    startActivity(intent);
                }
            });
        }
    }

    //timer
    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
        timerRunning = false;
    }

    private void startTimer() {
        countDownTimer.start();
        timerRunning = true;
    }

    //navigate to level 3
    private void navigateToLevel3() {
        Intent intent = new Intent(Level_2.this, Level_3.class);
        startActivity(intent);
        finish();
    }

    //navigate to game over
    private void navigateToGameOverPage() {
        Intent intent = new Intent(Level_2.this, gameover2.class);
        startActivity(intent);
        finish();
    }

}