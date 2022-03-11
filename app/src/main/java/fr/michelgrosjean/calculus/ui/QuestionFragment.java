package fr.michelgrosjean.calculus.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fr.michelgrosjean.calculus.R;
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
    private int currentIndexOfquestions = 0;
    private int NB_MAX_QUESTION = 5;

    public QuestionFragment() {
        super(R.layout.question_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        displayQuestions();
    }

    private void displayQuestions() {
        QuestionsGenerator questionsGenerator = new QuestionsGenerator();
        List<Operation> operations = questionsGenerator.generateQuestions(NB_MAX_QUESTION, Difficulty.EASY);
        String strQuestion;
        Operation operation = operations.get(currentIndexOfquestions);

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
        txtQuestion.setText("test");
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.answer1) {

        } else if (view.getId() == R.id.answer2) {

        } else if (view.getId() == R.id.answer3) {

        } else if (view.getId() == R.id.answer4) {

        }
        currentIndexOfquestions++;
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (!(currentIndexOfquestions >= NB_MAX_QUESTION)) {
                displayQuestions();
            } else {
                txtQuestion.setText("FIN");
            }
        }, 10);
    }
}
