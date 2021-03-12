package be.trewep.lettersapplication;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class GameViewModel extends ViewModel{
    private MutableLiveData<CharSequence> character;
    private int counter = 0;

    MutableLiveData<CharSequence> getChar() {
        if (character == null) {
            character = new MutableLiveData<CharSequence>(" ");
        }

        return character;
    }

    void setChar(CharSequence c) {
        character.setValue(c);
    }

    private char pickAChar() {
        Random random = new Random();
        int ascii = random.nextInt(26) + 97; // lowercase 'a'
        return (char)ascii;
    }

    private boolean isVowel (char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char v: vowels) {
            if (v == c) return true;
        }
        return false;
    }

    private boolean isConsonant (char c) {
        return !isVowel(c);
    }

    public void pickVowel() {
        char c;
        do {
            c = pickAChar();
        } while (!isVowel(c));
        if (!limitReached()) {
            setChar(String.valueOf(c));
        }
    }

    public void pickConsonant() {
        char c;
        do {
            c = pickAChar();
        } while (!isConsonant(c));
        if (!limitReached()) {
            setChar(String.valueOf(c));
        }
    }

    public void pickBigNumber(){
        Random random = new Random();
        Integer[] bigNumbers = {10, 25, 50, 100};

        int rndNumber = random.nextInt(bigNumbers.length);
        rndNumber = bigNumbers[rndNumber];

        if (!limitReached()) {
            setChar(String.valueOf(rndNumber));
        }
    }

    public void pickSmallNumber(){
        Random random = new Random();
        int rndNumber = random.nextInt(9)+1;

        if (!limitReached()) {
            setChar(String.valueOf(rndNumber));
        }
    }

    private boolean limitReached(){
        if(counter < 6){
            counter++;
            return false;
        } else {
            return true;
        }
    }

    public void clearCounter(){
        counter = 0;
    }

    public int pickGoalNumber(int limit){
        Random random = new Random();
        int rndNumber = random.nextInt(limit) + 1;
        return rndNumber;
    }
}