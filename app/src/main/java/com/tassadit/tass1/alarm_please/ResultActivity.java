package com.tassadit.tass1.alarm_please;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
//RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
//bar.setRating(score);
        switch (score)
        {
            case 1:
            case 2:
                t.setText("You got " + score + " points. You need more practise!");

                break;
            case 3:
            case 4:t.setText("You got " + score + " points.You have been practicing");
                break;
            case 5:t.setText("You got " + score + " points.Well done!");
                break;
        }
//TextView countDisplay;
//countDisplay = new TextView(this);
//this.setContentView(countDisplay);
//countDisplay.setText("The score is: "+ score);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i = new Intent (v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result , menu);
        return true;
    }
}
