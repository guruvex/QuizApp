package example.android.quizapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {

    // set global strings
    int count = 0;
    int count2 = 0;
    int rightAnswer =0;
    // table for questions and answers
    String[][] answerTable = new String [6][12];

    // set global views
    ViewFlipper pageFlipper;
    ScrollView introPage;
    TextView totalScore;
    ScrollView radioButtonPage;
    TextView radioQuestion;
    RadioGroup radioGroupBox;
    RadioButton radioAnswer1;
    RadioButton radioAnswer2;
    RadioButton radioAnswer3;
    RadioButton radioAnswer4;
    ScrollView checkBoxPage;
    TextView checkQuestion;
    CheckBox checkAnswer1;
    CheckBox checkAnswer2;
    CheckBox checkAnswer3;
    CheckBox checkAnswer4;
    ScrollView editPage;
    TextView editQuestion;
    EditText editUserInput;
    ScrollView imagePage;
    TextView imageQuestion;
    ImageView imagePicture;
    CheckBox imageCheckAnswer1;
    CheckBox imageCheckAnswer2;
    CheckBox imageCheckAnswer3;
    CheckBox imageCheckAnswer4;




    final String COUNT_A = "countA";
    final String COUNT_B = "countB";
    final String RIGHT_ANSWER = "rightAnswers";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // assign global views

        pageFlipper = findViewById(R.id.pageflipper);
        introPage = findViewById(R.id.intropage);
        totalScore = findViewById(R.id.totalscore);
        radioButtonPage = findViewById(R.id.radiobuttonpage);
        radioQuestion = findViewById(R.id.radioquestion);
        radioGroupBox = findViewById(R.id.radiogroupbox);
        radioAnswer1 = findViewById(R.id.radioanswer1);
        radioAnswer2 = findViewById(R.id.radioanswer2);
        radioAnswer3 = findViewById(R.id.radioanswer3);
        radioAnswer4 = findViewById(R.id.radioanswer4);
        checkBoxPage = findViewById(R.id.checkboxpage);
        checkQuestion = findViewById(R.id.checkquestion);
        checkAnswer1 = findViewById(R.id.checkanswer1);
        checkAnswer2 = findViewById(R.id.checkanswer2);
        checkAnswer3 = findViewById(R.id.checkanswer3);
        checkAnswer4 = findViewById(R.id.checkanswer4);
        editPage = findViewById(R.id.editpage);
        editQuestion = findViewById(R.id.editquestion);
        editUserInput = findViewById(R.id.edituserinput);
        imagePage = findViewById(R.id.imagepage);
        imageQuestion = findViewById(R.id.imagequestion);
        imagePicture = findViewById(R.id.imagepicture);
        imageCheckAnswer1 = findViewById(R.id.imagecheckanswer1);
        imageCheckAnswer2 = findViewById(R.id.imagecheckanswer2);
        imageCheckAnswer3 = findViewById(R.id.imagecheckanswer3);
        imageCheckAnswer4 = findViewById(R.id.imagecheckanswer4);

        buildAnswerTable();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_A, count);
        outState.putInt(COUNT_B, count2);
        outState.putInt(RIGHT_ANSWER, rightAnswer);
    }

    /** Restores app data on new state screen rotation */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        count =(savedInstanceState.getInt(COUNT_A));
        count2 =(savedInstanceState.getInt(COUNT_B));
        rightAnswer=(savedInstanceState.getInt(RIGHT_ANSWER));

    }

    public void pressAnswers(View view) {

        setTitle("Score "+ count);

        if (count == 4) {count = 0;}

        if (count== 0) {
            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.radiobuttonpage)));
            count++;
        } else if (count== 1) {
            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.checkboxpage)));
            count++;
        } else if (count== 2) {
            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.imagepage)));
            count++;
        } else if (count== 3) {
            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.editpage)));
            count++;
        }

        //screenSetup ();
        /**
        checkAnswer();

        count++;
        count2 = count2 + 4;

        if (count == 11) {
            count = 0;
            count2 = 0;
        }
        onWord(view);
        displayUpDate();
        **/

    }
    /** this will setup all the screens. **/
    public void screenSetup() {
        if (answerTable[count][2] != "game over") {

            if (answerTable[count][0] == "1") {
                // setup radio button page

                 radioQuestion.setText(answerTable[0][2]);
                 radioAnswer1.setText(answerTable[0][3]);
                 radioAnswer2.setText(answerTable[0][4]);
                 radioAnswer3.setText(answerTable[0][5]);
                 radioAnswer4.setText(answerTable[0][6]);

            } else if (answerTable[count][0] == "2") {
                // setup check box page

                 checkQuestion.setText(answerTable[count][2]);
                 checkAnswer1.setText(answerTable[count][3]);
                 checkAnswer2.setText(answerTable[count][4]);
                 checkAnswer3.setText(answerTable[count][5]);
                 checkAnswer4.setText(answerTable[count][6]);

            } else if (answerTable[count][0] == "3") {
                // setup edit  page

                 editQuestion.setText(answerTable[count][2]);


            } else if (answerTable[count][0] == "4") {
                // setup image page page
                 imagePicture.setImageResource (getResources().getIdentifier(answerTable[count][1],"drawable","com.app"));
                 imageQuestion.setText (answerTable[count][2]);
                 imageCheckAnswer1.setText (answerTable[count][3]);
                 imageCheckAnswer2.setText (answerTable[count][4]);
                 imageCheckAnswer3.setText (answerTable[count][5]);
                 imageCheckAnswer4.setText (answerTable[count][6]);


            }
            /**
             answerTable[x][0] = screenView[x];
             answerTable[x][1] = pictureArray[x];
             answerTable[x][2] = questionArray[x];
             answerTable[x][3] = answerArray[x];
             answerTable[x][4] = answerArray[x];
             answerTable[x][5] = answerArray[x];
             answerTable[x][6] = answerArray[x];
             answerTable[x][7] = userAnswersArray[x];
             **/
        }
    }
    /** this will check if the answer is right or not
        a * is correct a / is incorrect **/
 public void checkAnswer(){

     /** radio button **/
     /**
     if (answerFotmat[count]== 0) {
          if (answerKey[count] == 0 && a.isChecked() == true){
              rightAnswer++;
          } else if (answerKey[count] == 1 && b.isChecked() == true) {
              rightAnswer++;
          } else if (answerKey[count] == 2 && c.isChecked() == true) {
              rightAnswer++;
          } else if (answerKey[count] == 3 && d.isChecked() == true) {
              rightAnswer++;
          }
     }
      **/
     /** check box **/
     /**
     if (answerFotmat[count]== 1) {
         if (test[count][0] == 0 && cA.isChecked()== true ){
             if (test[count][1] == 1 && cB.isChecked()== true ){
                 rightAnswer++;
             }
         }

     }
      **/
     //if (answerFotmat[count]== 0) { // text answer}
    }

 /** this method will run when the intro page button is pressed **/
    public void onWord(View view) {

            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.radiobuttonpage)));
            count++;


        setTitle("Score "+ count);

     /**
        if (answerFotmat[count]== 0) {
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.radiobuttons)));
            displayUpDate();
        }
        if (answerFotmat[count]== 1) {
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.checkboxs)));
            displayUpDate();
        }
        if (answerFotmat[count]== 2) {
            // text answer
            // viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.)));
            // displayUpDate();
        }
      **/
    }
    /** this method builds the question and answer table from the strings.xml **/
    public void  buildAnswerTable () {
        int stepCount = 0; // applied to the answer set to get the correct 4 answers from the array

        Resources res = getResources();
        String[] questionArray = res.getStringArray(R.array.questions);
        String[] answerArray = res.getStringArray(R.array.answers);
        String[] userAnswersArray = res.getStringArray(R.array.useranswers);
        String[] pictureArray = res.getStringArray(R.array.pictures);
        String[] screenView = res.getStringArray(R.array.screenview);
        String[] correctAnswers = res.getStringArray(R.array.correctanswers);

        /**

        **/
        /** this will loop and build a table
         * of what screen is used [0], what picture (if needed) [1]
         * what question [2], and the 4 set answers. [3-6]
         * the 5th question is to match the user input [7]
         *
         * answerTable[0][0] =  "0";
         * answerTable[0][1] = "image";
         * answerTable[0][2] = "question";
         * answerTable[0][3] = "answer1";
         * answerTable[0][4] = "answer2";
         * answerTable[0][5] = "answer3";
         * answerTable[0][6] = "answer4";
         * answerTable[0][7] = "user input";

         */

            answerTable[0][0] = screenView[0];
            answerTable[0][1] = pictureArray[0];
            answerTable[0][2] = questionArray[0];
            answerTable[0][3] = answerArray[0]; // count 4
            answerTable[0][4] = answerArray[0];
            answerTable[0][5] = answerArray[0];
            answerTable[0][6] = answerArray[0]; // count 4
            answerTable[0][7] = userAnswersArray[0];
            answerTable[0][8] = correctAnswers[0]; // count 4
            answerTable[0][9] = correctAnswers[0];
            answerTable[0][10] = correctAnswers[0];
            answerTable[0][11] = correctAnswers[0]; // count 4




    }
    /** used to take the user to the intro page **/
    public void toTheStart(View view) {
            pageFlipper.setDisplayedChild(pageFlipper.indexOfChild(findViewById(R.id.intropage)));
    }
 public void test () {}


}
