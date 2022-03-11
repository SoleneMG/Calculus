package fr.michelgrosjean.calculus.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fr.michelgrosjean.calculus.R;
import fr.michelgrosjean.calculus.domain.QuestionsGenerator;

public class QuestionFragment extends Fragment implements View.OnClickListener{
    private TextView txtQuestion;
    private List<Button> buttons;

    public QuestionFragment() {
        super(R.layout.question_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView(){
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
        Toast toast = null;
        if (view.getId() == R.id.answer1) {
            toast = Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT);
        } else if (view.getId() == R.id.answer2) {
            toast = Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT);
        } else if (view.getId() == R.id.answer3) {
            toast = Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT);
        } else if (view.getId() == R.id.answer4) {
            toast = Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT);
        }
        Objects.requireNonNull(toast).show();
    }
}
