package be.trewep.lettersapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Fragment currentLayout; //holds current fragment that's being shown

    final LetterFragment letterFragment = new LetterFragment();
    final NumberFragment numberFragment = new NumberFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLayout = letterFragment; //Starting Layout

        Button btnChange = findViewById(R.id.btn_switch); //switch button to change

        FragmentManager fm = getSupportFragmentManager(); //initialize fragment manager
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentSpot, currentLayout); //replace starting fragment with LetterFragment
        ft.commit();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentLayout == letterFragment) {
                    currentLayout = numberFragment;
                } else {
                    currentLayout = letterFragment;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentSpot, currentLayout);
                ft.commit();
            }
        });
    }
}