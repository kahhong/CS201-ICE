package com.skahhong.playground.ice1;

public class Q4a {
    public static int findRepeated(int[] input) {
        if(input.length < 6) return 0;

        int length = input.length;

        /*
            Number of additions: n - 5
            Number of comparisons: n - 5 + 1 = n - 4
         */
//        int sumOfAllRunningNumbers = 0;
//        for(int i = 1; i <= length - 5; i++) {
//
//            sumOfAllRunningNumbers += i;
//        }


        /*
            Using the Arithmetic Series Formula
         */
        int sumOfAllRunningNumbers = ( length - 4 ) * (length - 5) / 2;


        /*
            Number of additions: length
            Number of comparisons: n + 1
         */
        int sumOfElementsInArray = 0;
        for (int j : input) {
            sumOfElementsInArray += j;
        }

        int sumOfRepeatedDigits = sumOfElementsInArray - sumOfAllRunningNumbers;
        int numberOfRepeatedDigits = 5;

        return sumOfRepeatedDigits / numberOfRepeatedDigits;
    }
}
