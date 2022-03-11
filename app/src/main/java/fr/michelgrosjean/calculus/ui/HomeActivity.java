package fr.michelgrosjean.calculus.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.michelgrosjean.calculus.R;

public class HomeActivity extends AppCompatActivity {

    public HomeActivity() {
        super(R.layout.activity_home);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, RulesAndDifficultFragment.class, null)
                    .commit();
        }
    }
}
