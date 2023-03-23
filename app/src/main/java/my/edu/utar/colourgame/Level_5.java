package my.edu.utar.colourgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level_5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_level5);

        button = (Button) findViewById(R.id.endGame5);

        //navigate to Bye page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level_5.this,Bye.class);
                startActivity(intent);
            }
        });

        timerTextView = findViewById(R.id.timertextView);
        btnBgSelector = findViewById(R.id.btnBgSelector5);

        //array for all button
        Button[] buttons = new Button[35];
        buttons[0] = (Button)findViewById(R.id.btnBgSelectorDisabled1);
        buttons[1] = (Button)findViewById(R.id.btnBgSelectorDisabled2);
        buttons[2] = (Button)findViewById(R.id.btnBgSelectorDisabled3);
        buttons[3] = (Button)findViewById(R.id.btnBgSelectorDisabled4);
        buttons[4] = (Button)findViewById(R.id.btnBgSelectorDisabled5);
        buttons[5] = (Button)findViewById(R.id.btnBgSelectorDisabled6);
        buttons[6] = (Button)findViewById(R.id.btnBgSelectorDisabled7);
        buttons[7] = (Button)findViewById(R.id.btnBgSelectorDisabled8);
        buttons[8] = (Button)findViewById(R.id.btnBgSelectorDisabled9);
        buttons[9] = (Button)findViewById(R.id.btnBgSelectorDisabled10);
        buttons[10] = (Button)findViewById(R.id.btnBgSelectorDisabled11);
        buttons[11] = (Button)findViewById(R.id.btnBgSelectorDisabled12);
        buttons[12] = (Button)findViewById(R.id.btnBgSelectorDisabled13);
        buttons[13] = (Button)findViewById(R.id.btnBgSelectorDisabled14);
        buttons[14] = (Button)findViewById(R.id.btnBgSelectorDisabled15);
        buttons[15] = (Button)findViewById(R.id.btnBgSelectorDisabled16);
        buttons[16] = (Button)findViewById(R.id.btnBgSelectorDisabled17);
        buttons[17] = (Button)findViewById(R.id.btnBgSelectorDisabled18);
        buttons[18] = (Button)findViewById(R.id.btnBgSelectorDisabled19);
        buttons[19] = (Button)findViewById(R.id.btnBgSelectorDisabled20);
        buttons[20] = (Button)findViewById(R.id.btnBgSelectorDisabled21);
        buttons[21] = (Button)findViewById(R.id.btnBgSelectorDisabled22);
        buttons[22] = (Button)findViewById(R.id.btnBgSelectorDisabled23);
        buttons[23] = (Button)findViewById(R.id.btnBgSelectorDisabled24);
        buttons[24] = (Button)findViewById(R.id.btnBgSelectorDisabled25);
        buttons[25] = (Button)findViewById(R.id.btnBgSelectorDisabled26);
        buttons[26] = (Button)findViewById(R.id.btnBgSelectorDisabled27);
        buttons[27] = (Button)findViewById(R.id.btnBgSelectorDisabled28);
        buttons[28] = (Button)findViewById(R.id.btnBgSelectorDisabled29);
        buttons[29] = (Button)findViewById(R.id.btnBgSelectorDisabled30);
        buttons[30] = (Button)findViewById(R.id.btnBgSelectorDisabled31);
        buttons[31] = (Button)findViewById(R.id.btnBgSelectorDisabled32);
        buttons[32] = (Button)findViewById(R.id.btnBgSelectorDisabled33);
        buttons[33] = (Button)findViewById(R.id.btnBgSelectorDisabled34);
        buttons[34] = (Button)findViewById(R.id.btnBgSelectorDisabled35);

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
                    navigateToSuccess();
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

    //navigate to success page
    private void navigateToSuccess() {
        Intent intent = new Intent(Level_5.this, success.class);
        startActivity(intent);
        finish();
    }

    //navigate to game over
    private void navigateToGameOverPage() {
        Intent intent = new Intent(Level_5.this, gameover.class);
        startActivity(intent);
        finish();
    }
}