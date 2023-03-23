package my.edu.utar.colourgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gameover2 extends AppCompatActivity {

    // These are the global variables
    TextView result, score;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover2);

        //navigate to Main Activity when the button is clicked
        button = (Button)findViewById(R.id.retry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Get the text from the Intent extra
        String text = intent.getStringExtra("my_text");

        // Set the text in a TextView in this activity
        TextView textView = findViewById(R.id.showScore);
        textView.setText(text);
    }

    //function to navigate to main activity
    public void openMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}