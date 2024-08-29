package com.skahhong.playground.ice1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Q4aTest {

    public int findRepeated(int[] input) {
        if(input.length < 6) return 0;

        int length = input.length;

        /*
            Number of additions: n - 5
            Number of comparisons: n - 5 + 1 = n - 4
         */
        int sumOfAllRunningNumbers = 0;
        for(int i = 1; i <= length - 5; i++) {

            sumOfAllRunningNumbers += i;
        }


        /*
            Using the Arithmetic Series Formula
         */
//        int sumOfAllRunningNumbers = ( length - 4 ) * (length - 5) / 2;


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

    @Test
    public void arrayWithLessThan6Elements() {
        int[] array = {1};

        assertThat(findRepeated(array)).isEqualTo(0);
    }

    @Test
    public void arrayWith6Elements() {
        int[] array = {1, 1, 1, 1, 1, 1, 2};

        assertThat(findRepeated(array)).isEqualTo(1);
    }

    @Test
    public void arrayWith7Elements() {
        int[] array = {3, 3, 3, 3, 3, 1, 2, 3};

        assertThat(findRepeated(array)).isEqualTo(3);
    }

    @Test
    public void arrayWith10Elements() {
        int[] array = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5};

        assertThat(findRepeated(array)).isEqualTo(5);
    }
}