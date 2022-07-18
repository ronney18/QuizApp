package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    RadioButton button_1a, button_1b, button_1c, button_1d;
    RadioButton button_3a, button_3b;
    RadioButton button_5a, button_5b, button_5c, button_5d;
    EditText question4, question6;
    CheckBox box1, box2, box3, box4, box5, box6, box7, box8;
    Button submit;

    boolean q1_right = false;
    boolean q3_right = false;
    boolean q5_right = false;
    int totalQuestions = 6;
    double totalCorrect = 0.0;
    double score = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1a = (RadioButton) findViewById(R.id.radio_button1a);
        button_1b = (RadioButton) findViewById(R.id.radio_button1b);
        button_1c = (RadioButton) findViewById(R.id.radio_button1c);
        button_1d = (RadioButton) findViewById(R.id.radio_button1d);
        box1 = (CheckBox) findViewById(R.id.checkBox1);
        box2 = (CheckBox) findViewById(R.id.checkBox2);
        box3 = (CheckBox) findViewById(R.id.checkBox3);
        box4 = (CheckBox) findViewById(R.id.checkBox4);
        box5 = (CheckBox) findViewById(R.id.checkBox5);
        box6 = (CheckBox) findViewById(R.id.checkBox6);
        box7 = (CheckBox) findViewById(R.id.checkBox7);
        box8 = (CheckBox) findViewById(R.id.checkBox8);
        button_3a = (RadioButton) findViewById(R.id.radio_button3a);
        button_3b = (RadioButton) findViewById(R.id.radio_button3b);
        button_5a = (RadioButton) findViewById(R.id.radio_button5a);
        button_5b = (RadioButton) findViewById(R.id.radio_button5b);
        button_5c = (RadioButton) findViewById(R.id.radio_button5c);
        button_5d = (RadioButton) findViewById(R.id.radio_button5d);
        question4 = (EditText) findViewById(R.id.text_q4);
        question6 = (EditText) findViewById(R.id.text_q6);
        submit = (Button) findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(button_1a.isChecked() || button_1b.isChecked() || button_1c.isChecked() ||
                        button_1d.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Question 1 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                }
                else if (!(box1.isChecked() || box2.isChecked() || box3.isChecked() || box4.isChecked() ||
                        box5.isChecked() || box6.isChecked() || box7.isChecked() || box8.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Question 2 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                } else if (!(button_3a.isChecked() || button_3b.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Question 3 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                } else if (question4.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Question 4 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                } else if (!(button_5a.isChecked() || button_5b.isChecked() || button_5c.isChecked() ||
                        button_5d.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Question 5 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                } else if (question6.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Question 6 is left unanswered!",
                            Toast.LENGTH_LONG).show();
                } else {
                    totalCorrect = 0.0;
                    score = 0.0;
                    if (box1.isChecked() && box2.isChecked() && box3.isChecked() && box4.isChecked()) {
                        score = score + 17;
                        totalCorrect = totalCorrect + 1.0;
                    } else if ((box1.isChecked() && box2.isChecked() && box3.isChecked()) ||
                            (box2.isChecked() && box3.isChecked() && box4.isChecked()) ||
                            (box1.isChecked() && box3.isChecked() && box4.isChecked()) ||
                            (box1.isChecked() && box2.isChecked() && box4.isChecked())) {
                        score = score + 12.75;
                        totalCorrect = totalCorrect + 0.75;
                    } else if ((box1.isChecked() && box2.isChecked()) || (box3.isChecked() && box4.isChecked()) ||
                            (box1.isChecked() && box3.isChecked()) || (box1.isChecked() && box1.isChecked())) {
                        score = score + 8.5;
                        totalCorrect = totalCorrect + 0.5;
                    } else if (box1.isChecked() || box2.isChecked() || box3.isChecked() || box4.isChecked()) {
                        score = score + 4.25;
                        totalCorrect = totalCorrect + 0.25;
                    } else {
                        totalCorrect = totalCorrect + 0.0;
                        score = score + 0.0;
                    }

                    if (question4.getText().toString().equals("6.022x10^23") ||
                            question4.getText().toString().equals("6.022 x 10^23") ||
                            question4.getText().toString().equals("6.022 x10^23") ||
                            question4.getText().toString().equals("6.022x 10^23") ||
                            question4.getText().toString().equals("6.022X10^23") ||
                            question4.getText().toString().equals("6.022 X 10^23") ||
                            question4.getText().toString().equals("6.022 X10^23") ||
                            question4.getText().toString().equals("6.022X 10^23")) {
                        score = score + 17;
                        totalCorrect = totalCorrect + 1.0;
                    }

                    if (q1_right) {
                        score = score + 16;
                        totalCorrect = totalCorrect + 1.0;
                    }

                    if (q3_right) {
                        score = score + 17;
                        totalCorrect = totalCorrect + 1.0;
                    }

                    if (q5_right) {
                        score = score + 16;
                        totalCorrect = totalCorrect + 1.0;
                    }

                    if (question6.getText().toString().equals("25")) {
                        score = score + 17;
                        totalCorrect = totalCorrect + 1.0;
                    }

                    Toast.makeText(getApplicationContext(), "Total Questions: " + totalQuestions +
                            "\nTotal Correct Answers: " + totalCorrect + "\nYour Score: " + score +
                            " / 100", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, QuizResults.class);
                    intent.putExtra("totalQuestions", totalQuestions);
                    intent.putExtra("userScore", score);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    public void toDo_question1(View v)
    {
        if(v.equals(button_1a))
        {
            q1_right = true;
        }

        else
        {
            q1_right = false;
        }
        Toast.makeText(getApplicationContext(), "Answer Saved!", Toast.LENGTH_SHORT).show();
    }

    public void toDo_question3(View v)
    {
        if(v.equals(button_3a))
        {
            q3_right = true;
        }

        else
        {
            q3_right = false;
        }
        Toast.makeText(getApplicationContext(), "Answer Saved!", Toast.LENGTH_SHORT).show();
    }
    public void toDo_question5(View v)
    {
        if(v.equals(button_5b))
        {
            q5_right = true;
        }
        else
        {
            q5_right = false;
        }
        Toast.makeText(getApplicationContext(), "Answer Saved!", Toast.LENGTH_SHORT).show();
    }
}
