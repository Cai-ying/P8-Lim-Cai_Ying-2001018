package my.edu.utar.colourgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bye extends AppCompatActivity {

    public Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);

        button1 = (Button) findViewById(R.id.toMain);

        //navigate to Main Activity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bye.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }}