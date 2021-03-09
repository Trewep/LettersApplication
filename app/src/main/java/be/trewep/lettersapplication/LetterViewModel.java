package be.trewep.lettersapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LetterViewModel extends ViewModel {
    private MutableLiveData <Character> letter;

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
