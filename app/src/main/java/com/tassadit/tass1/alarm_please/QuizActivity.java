package com.tassadit.tass1.alarm_please;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class QuizActivity extends Activity {
    List<Question> quesList;
    int score=0;
    //will randomize the number
    int qid=0;
    int[] a = new int[10];

    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    int count = 1;
    //we want numbers up to 10
    final Random myRandom = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//setting all values of the array to zero
        for(int i=0;i<10;i++)
        {
            a[i] = 0;
        }
        setContentView(R.layout.activity_quiz);
        DBHelper db=new DBHelper(this);
        quesList=db.getAllQuestions();
        qid = myRandom.nextInt(9) +1;
//We want to make sure that each question only appears once.
        while(a[qid] !=0)
        {
            qid = myRandom.nextInt(9) +1;
        }
        currentQ=quesList.get(qid);
        a[qid] = 1;
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(score<5){
                    qid = myRandom.nextInt(9) +1;
                    //We want to make sure that each question only appears once.
                    if(count == 10)
                    {
                        DialogForProgram show = new DialogForProgram();
                    }
                    while(a[qid] !=0)
                    {
                        qid = myRandom.nextInt(9) +1;
                    }
                    a[qid] =1;
                    currentQ=quesList.get(qid);
                    count++;
                    setQuestionView();
                }
                else{
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
//finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}
