package org.emeritus.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;


public class Chapter1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Question 1.3
//        String str = "Mr John Smkith    ";
//        char[] arr = str.toCharArray();
//        int trueLength = findLastCharacter(arr) + 1;
//        replaceSpaces(arr, trueLength);
        Log.d("darran", "" + isPalindrome("Rats live on no evil star"));
        Log.d("darran", "The numeric value of a is: " + Character.getNumericValue('a'));
        Log.d("darran", "The numeric value of b is: " + Character.getNumericValue('b'));
        Log.d("darran", "The numeric value of y is: " + Character.getNumericValue('y'));
        Log.d("darran", "The numeric value of z is: " + Character.getNumericValue('z'));
    }

    public boolean isPalindrome(String palindromeTestString) {
        String allLowerCase = palindromeTestString.toLowerCase();
        int[] charCount = new int[128];

        boolean isEven = (palindromeTestString.length() % 2) == 0;

        for (char c : allLowerCase.toCharArray()) {
            charCount[c]++;
        }
        int oddCount = 0;
        for (int characterCount : charCount) {
            if (characterCount % 2 !=0) {
                oddCount++;
                if (isEven || oddCount > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public void replaceSpaces(char[] incomingString, int stringLength) {
        int trueLength = stringLength + (countSpaces(incomingString, stringLength) *2);

        while (stringLength > 0 ) {
            if (incomingString[stringLength -1] != ' ') {
                incomingString[trueLength -1] = incomingString[stringLength -1];
                trueLength--;
            } else {
                incomingString[trueLength-1] = '0';
                incomingString[trueLength-2] = '2';
                incomingString[trueLength-3] = '%';
                trueLength = trueLength - 3;
            }
            stringLength--;
            Log.d("darran", "The string is: " +Arrays.toString(incomingString));
        }

    }

    private int countSpaces(char[] incomingString, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (incomingString[i] == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    private int getLastCharacterPosition(char[] incomingString) {
        for (int i = incomingString.length - 1; i >= 0; i--) {
            if (incomingString[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
