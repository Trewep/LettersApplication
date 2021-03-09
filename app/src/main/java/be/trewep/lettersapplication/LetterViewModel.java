package be.trewep.lettersapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData <Character> letter;
    private MutableLiveData <Integer> number;

    public MutableLiveData <Character> getLetter(){
        if (letter == null){
            letter= new MutableLiveData <Character>();
        }
        return letter;
    }

    public void setLetter(char c){
        letter.setValue(c);
    }

}
