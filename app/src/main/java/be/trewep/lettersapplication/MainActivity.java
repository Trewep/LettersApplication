package be.trewep.lettersapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLetter;
    LetterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvLetter = findViewById(R.id.tv_letter);

        viewModel.getLetter().observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                tvLetter.setText(character.toString());

            }
        });
    }
}