package my.edu.utar.colourgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Level_1 extends AppCompatActivity {

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
        setContentView(R.layout.activity_level1);

        button = (Button) findViewById(R.id.endGame1);

        //navigate to Bye page when press the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level_1.this,Bye.class);
                startActivity(intent);
            }
        });


        timerTextView = findViewById(R.id.timertextView);
        btnBgSelector = findViewById(R.id.btnBgSelector);

        //array for all button
        Button[] buttons = new Button[3];
        buttons[0] = (Button)findViewById(R.id.btnBgSelectorDisabled1);
        buttons[1] = (Button)findViewById(R.id.btnBgSelectorDisabled2);
        buttons[2] = (Button)findViewById(R.id.btnBgSelectorDisabled3);

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
                    navigateToLevel2();
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

    //navigate to level 2
    private void navigateToLevel2() {
        Intent intent = new Intent(Level_1.this, Level_2.class);
        startActivity(intent);
        finish();
    }

    //navigate to game over
    private void navigateToGameOverPage() {
        Intent intent = new Intent(Level_1.this, gameover.class);
        startActivity(intent);
        finish();
    }
}