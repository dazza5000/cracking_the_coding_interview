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
//        Log.d("darran", realToString(.72));
        Log.d("darran", "longest sequence: " + longestSequence(Integer.parseInt("100101", 2)));
        Log.d("darran", "nextSmallestAndLargest: " + nextSmallestAndLargest(Integer.parseInt("100101", 2)));
    }

    // Cracking the coding interview 5.1

    private int intoN(int M, int N, int i, int j ) {

        // Create a left side of the mask that is all 1's follo+wed by zeros
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

    // Cracking the coding interview 5.3
    private int longestSequence(int incoming) {
        if (incoming == ~0) {
            return Integer.MAX_VALUE;
        }

        int maxSegment = 0;
        int currentSegment = 0;
        int previousSegment = 0;

        while (incoming > 0) {
            if ((incoming & 1) == 1) {
                currentSegment +=1;
            } else {
                    previousSegment = currentSegment +1;
                    currentSegment = 0;
                if ((incoming & 2) == 0) {
                    previousSegment = 0;
            }

            }

            incoming = incoming >> 1;
            Log.d("darran", "current segment is: " +currentSegment);
            Log.d("darran", "previous segment is: " +previousSegment);
            asBinary(incoming);

            maxSegment = Math.max(maxSegment, currentSegment + previousSegment);

        }

        return maxSegment;
    }

    public String nextSmallestAndLargest(int positiveInteger) {
        if (positiveInteger <= 0)
            return "INVALID";

        StringBuilder stringBuilder = new StringBuilder();

//        int largestZero = getLargestZero(positiveInteger);
//        asBinary(largestZero);
//        int mask = 1 << (largestZero - 1);
//        asBinary(mask);
//        int dividedBy2 = positiveInteger / 2;
//        asBinary(dividedBy2);
//        int nextSmallest = dividedBy2 | mask;
//        asBinary(nextSmallest);

        int mask = 1 << getSmallestZero(positiveInteger);
        int smallestOne = getSmallestOne(positiveInteger);
        positiveInteger |=  mask;
        positiveInteger ^=  (1 << smallestOne);

        return stringBuilder.append(asBinary(positiveInteger)).toString();
    }

    private int getSmallestZero(int incomingInteger) {

        int smallestZero = 0;
        int currentPosition = 0;
        while (incomingInteger > 0) {
            if ((incomingInteger & 1) != 1) {
                smallestZero = currentPosition;
                return smallestZero;
            }
            currentPosition += 1;
            incomingInteger >>= 1;
        }
        return smallestZero;
    }

    private int getSmallestOne(int incomingInteger) {

        int smallest = 0;
        int currentPosition = 0;
        while (incomingInteger > 0) {
            if ((incomingInteger & 1) == 1) {
                smallest = currentPosition;
                return smallest;
            }
            currentPosition += 1;
            incomingInteger >>= 1;
        }
        return smallest;
    }

    private int getLargestZero(int incomingInteger) {

        int largestZero = 0;
        int currentPosition = 0;
        while (incomingInteger > 0) {
            if ((incomingInteger & 1) == 1) {
                largestZero = currentPosition;
            }
            currentPosition += 1;
            incomingInteger >>= 1;
        }
        return largestZero;
    }


    private String asBinary(int toBinary) {
        Log.d("darran", Integer.toBinaryString(toBinary));
        return Integer.toBinaryString(toBinary);
    }
}
