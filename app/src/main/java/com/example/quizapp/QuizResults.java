package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QuizResults extends AppCompatActivity {

    EditText totalQuestions, userScore;
    Button tryAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        totalQuestions = (EditText) findViewById(R.id.numQuestions);
        userScore = (EditText) findViewById(R.id.quizScore);

        Intent caller = getIntent();
        int myQuestionsTotal = caller.getIntExtra("totalQuestions", 0);
        double myScore = caller.getDoubleExtra("userScore", 0.0);
        totalQuestions.setText("" + myQuestionsTotal);
        userScore.setText("" + myScore);
        tryAgain = (Button) findViewById(R.id.tryAgainBtn);

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResults.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
