package fr.michelgrosjean.calculus.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fr.michelgrosjean.calculus.R;
import fr.michelgrosjean.calculus.domain.AnswersGenerator;
import fr.michelgrosjean.calculus.domain.QuestionsGenerator;
import fr.michelgrosjean.calculus.model.Difficulty;
import fr.michelgrosjean.calculus.model.Divide2Operation;
import fr.michelgrosjean.calculus.model.Multiply2Operation;
import fr.michelgrosjean.calculus.model.Operation;
import fr.michelgrosjean.calculus.model.Substraction2NegativeOperation;
import fr.michelgrosjean.calculus.model.Substraction2PositiveOperation;
import fr.michelgrosjean.calculus.model.Sum2Operation;
import fr.michelgrosjean.calculus.model.Sum3Operation;

public class QuestionFragment extends Fragment implements View.OnClickListener {
    private TextView txtQuestion;
    private List<Button> buttons;
    private Difficulty difficulty;
    private List<Operation> operations;
    private int currentIndexOfquestions = 0;
    private int NB_MAX_QUESTION = 5;
    private List<Integer> answers = new ArrayList<>();
    private int result;
    private int score = 0;

    public QuestionFragment() {
        super(R.layout.question_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        operations = generateQuestions();
        displayQuestions(operations.get(currentIndexOfquestions));
        answers = generateAnswers(operations.get(currentIndexOfquestions));
        displayAnswers(answers);
    }
    private void displayAnswers(List<Integer> answers){
        for(int i =0; i<buttons.size(); i++){
            buttons.get(i).setText(String.valueOf(answers.get(i)));
        }
    }

    private List<Integer> generateAnswers(Operation operation){
        AnswersGenerator answersGenerator = new AnswersGenerator(operation);
        result = answersGenerator.compute();
        return answersGenerator.generateAnswers();
    }

    private  List<Operation> generateQuestions(){
        difficulty = getDifficulty();
        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        return questionsGenerator.generateQuestions(NB_MAX_QUESTION, difficulty);
    }

    private void displayQuestions(Operation operation) {
        String strQuestion;

        switch (operation.type) {
            case Sum2Operation:
                Sum2Operation opSum = (Sum2Operation) operation;
                strQuestion = opSum.number1 + " + " + opSum.number2 + " = ?";
                break;
            case Substraction2PositiveOperation:
                Substraction2PositiveOperation opSubPos = (Substraction2PositiveOperation) operation;
                strQuestion = opSubPos.number1 + " - " + opSubPos.number2 + " = ?";
                break;
            case Substraction2NegativeOperation:
                Substraction2NegativeOperation opSubNeg = (Substraction2NegativeOperation) operation;
                strQuestion = opSubNeg.number1 + " - " + opSubNeg.number2 + " = ?";
                break;
            case Multiply2Operation:
                Multiply2Operation opMultiply = (Multiply2Operation) operation;
                strQuestion = opMultiply.number1 + " * " + opMultiply.number2 + " = ?";
                break;
            case Divide2Operation:
                Divide2Operation opDiv = (Divide2Operation) operation;
                strQuestion = opDiv.number1 + " / " + opDiv.number2 + " = ?";
                break;
            case Sum3Operation:
                Sum3Operation opSum3 = (Sum3Operation) operation;
                strQuestion = opSum3.number1 + " + " + opSum3.number2 + " + " + opSum3.number3 + " = ?";
                break;
            default:
                throw new IllegalArgumentException("Type not supported");
        }
        txtQuestion.setText(strQuestion);
    }

    private Difficulty getDifficulty(){
        Bundle arguments = getArguments();
        return (Difficulty) (arguments != null ? arguments.get("difficulty") : null);
    }

    private void initView() {
        txtQuestion = Objects.requireNonNull((getView())).findViewById(R.id.question);
        Button answer1 = getView().findViewById(R.id.answer1);
        Button answer2 = getView().findViewById(R.id.answer2);
        Button answer3 = getView().findViewById(R.id.answer3);
        Button answer4 = getView().findViewById(R.id.answer4);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);
        buttons = new ArrayList<>(Arrays.asList(answer1, answer2, answer3, answer4));
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.answer1){
            checkAnswer(buttons.get(0));
        } else if(view.getId() == R.id.answer2){
            checkAnswer(buttons.get(1));
        } else if(view.getId() == R.id.answer3){
            checkAnswer(buttons.get(2));
        } else if(view.getId() == R.id.answer4){
            checkAnswer(buttons.get(3));}
        nextQuestion();
    }
/*
I use an handler to have time to vizualise if answer is correct
 */
    private void nextQuestion(){
        currentIndexOfquestions++;
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (!(currentIndexOfquestions >= NB_MAX_QUESTION)) {
                displayQuestions(operations.get(currentIndexOfquestions));
                answers = generateAnswers(operations.get(currentIndexOfquestions));
                displayAnswers(answers);

            } else {
                txtQuestion.setText("FIN");
            }
            for (Button button : buttons) {
                button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_200));
            }
        }, 500);
    }

    private void checkAnswer(Button button){
        if(button.getText().equals(String.valueOf(result))){
            button.setBackgroundColor(Color.GREEN);
            score++;
        } else {
            button.setBackgroundColor(Color.RED);
        }
    }
}
