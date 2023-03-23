package my.edu.utar.colourgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameover extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        //navigate to Main Activity when the button is clicked
        button = (Button)findViewById(R.id.retry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }

    //function to navigate to main activity
    public void openMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}