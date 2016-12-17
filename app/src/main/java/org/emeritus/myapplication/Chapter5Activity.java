package org.emeritus.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class Chapter5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("darran", Integer.toBinaryString(intoN(19, 1024, 2, 6)));
//        Log.d("darran", Integer.toBinaryString(intoN(19, 1283, 2, 6)));
        Log.d("darran", realToString(.72));
    }

    // Cracking the coding interview 5.1

    private int intoN(int M, int N, int i, int j ) {

        // Create a left side of the mask that is all 1's followed by zeros
        //11111111111111111111111110000000
        int leftMask = (~0 << (j+1));
        asBinary(leftMask);

        // Create the right side of the mask that is all 0's followed by 1's
        //....00000011
        int rightMask = (1 << i) -1;
        asBinary(rightMask);

        // Combine both masks
        // 11111111111111111111111110000011
        int combinedMask =  leftMask | rightMask;
        asBinary(combinedMask);

        // Combine N with mask
        // 10000000000
        N &= combinedMask;
        asBinary(N);

        // Shift M by i places
        M <<= i;
        asBinary(M);

        //Returned N combined with M using OR bitwise operator;
        return (N | M);
    }

    // Cracking the coding interview 5.2
    private String realToString(double real) {
        if ((real >= 1L) || (real <= 0L)) {
            return "ERROR";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".");
        while (real > 0) {
            if (stringBuilder.length() > 32) {
                return "ERROR";
            }
            double num = real *2;
            Log.d("darran", "num is: "+num);
            if (num >= 1) {
                stringBuilder.append(1);
                real = num - 1;
            } else {
                stringBuilder.append(0);
                real = num;
            }
            Log.d("darran", "current string is: " +stringBuilder.toString());
        }

        return stringBuilder.toString();
    }


    private void asBinary(int toBinary) {
        Log.d("darran", Integer.toBinaryString(toBinary));
    }
}
