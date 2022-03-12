package fr.michelgrosjean.calculus.ui;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import fr.michelgrosjean.calculus.R;
import fr.michelgrosjean.calculus.model.Difficulty;

public class RulesAndDifficultFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rules_and_difficult_choice_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initButton(view);
    }

    private void initButton(View view){
        Button easyDifficulty, mediumDifficulty, hardDifficulty;
        easyDifficulty = view.findViewById(R.id.btn_easy);
        mediumDifficulty = view.findViewById(R.id.btn_medium);
        hardDifficulty = view.findViewById(R.id.btn_hard);
        easyDifficulty.setOnClickListener(this);
        mediumDifficulty.setOnClickListener(this);
        hardDifficulty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_easy){
            switchFragment(Difficulty.EASY);
        } else if(view.getId() == R.id.btn_medium){
            switchFragment(Difficulty.MEDIUM);
        } else if(view.getId() == R.id.btn_hard){
            switchFragment(Difficulty.HARD);
        }
    }
    /*
        I use an enum to transfer difficultyLevel using fragment transactions
    */
    private void switchFragment(Difficulty difficulty){
        Bundle arguments = new Bundle();
        arguments.putSerializable( "difficulty" , difficulty);
        getParentFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, QuestionFragment.class, arguments, "DIFFICULTY")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}
