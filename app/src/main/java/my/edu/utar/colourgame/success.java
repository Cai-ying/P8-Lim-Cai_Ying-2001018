package my.edu.utar.colourgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;


public class success extends AppCompatActivity{

    // These are the global variables
    EditText editName;
    TextView result;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        editName  = (EditText) findViewById(R.id.editName);
        result = (TextView) findViewById(R.id.tvResult);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get text from EditText name view
                String name = editName.getText().toString();
                result.setText(name + "   25 ");
            }
        });
    }

}

