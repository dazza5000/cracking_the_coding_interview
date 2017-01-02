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

        Log.d("darran", "" + oneAway("bake", "make"));

        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

        int[][] testMatrix = new int[7][7];
        Log.d("darran", "matrix is" +Arrays.deepToString(testMatrix));

        int[][] matrix = randomMatrix(3, 3, 0, 9);

        Log.d("darran", "matrix is" +Arrays.deepToString(matrix));

        Log.d("darran", "matrix is" +Arrays.deepToString(rotateMatrix(matrix)));

    }

    public int[][] rotateMatrix(int[][] matrix) {
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;

        int[][] rotatedMatrix = new int[matrixHeight][matrixWidth];

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j  < matrixWidth; j++) {
                rotatedMatrix[j][matrixWidth -1 -i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public boolean oneAway(String stringOne, String stringTwo) {
        int diffCount = 0;
        int lengthDiff = Math.abs(stringOne.length() - stringTwo.length());
        int currentChar = 0;


        if (lengthDiff > 1) {
            return false;
        } else if (lengthDiff == 1) {
            diffCount++;
        }
        for (int i = 0;  i < stringOne.length() && i < stringTwo.length(); i++) {
            if(stringOne.charAt(i) != stringTwo.charAt(i)) {
                diffCount++;
                break;
            }
        }

        if (diffCount <=1) {
            diffCountBackwards(stringOne, stringTwo, currentChar, diffCount);
        }

        return diffCount <= 1;
    }

    private void diffCountBackwards(String stringOne, String stringTwo, int currentChar, int diffCount) {

        int index = 1;
        while (((stringOne.length() -index) >= currentChar) && ((stringTwo.length() - index) >= currentChar)) {
            if ((stringOne.charAt(stringOne.length()-index)) != (stringTwo.charAt(stringTwo.length()-index))) {
                diffCount +=1;
                if (diffCount > 1) {
                    return;
                }
            }
            index++;
        }
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

    public void test(String a, String b, boolean expected) {
        boolean resultA = oneAway(a, b);

        if (resultA == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }


    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }
}
