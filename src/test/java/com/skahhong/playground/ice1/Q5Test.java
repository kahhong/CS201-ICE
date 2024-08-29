package com.skahhong.playground.ice1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Q5Test {

    public int[][][] addTwo3DArrays(int[][][] arr1, int[][][] arr2) {
        int[][][] sum = new int[arr1.length][arr1[0].length][arr1[0][0].length];

        /*
            There is a total of i * j * k additions (excluding the loop incrementing counters)
         */
        for(int i = 0; i < arr1[0][0].length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                for (int k = 0; k < arr1.length; k++) {
                    sum[k][j][i] = arr1[k][j][i] + arr2[k][j][i];
                }
            }
        }
        return sum;
    }

    @Test
    public void test1() {
        int[][][] arr1 = {{{1}}};
        int[][][] arr2 = {{{1}}};
        int[][][] expectedResult = {{{2}}};

        assertThat(addTwo3DArrays(arr1, arr2))
                .hasSameDimensionsAs(arr1)
                .isDeepEqualTo(expectedResult);
    }

    @Test
    public void test2() {
        int[][][] arr1 = {{{1}, {1}, {1}}};
        int[][][] arr2 = {{{1}, {1}, {1}}};
        int[][][] expectedResult = {{{2}, {2}, {2}}};

        assertThat(addTwo3DArrays(arr1, arr2))
                .hasSameDimensionsAs(arr1)
                .isDeepEqualTo(expectedResult);
    }

    @Test
    public void test3() {
        int[][][] arr1 = {{{1}}, {{1}}, {{1}}};
        int[][][] arr2 = {{{1}}, {{1}}, {{1}}};
        int[][][] expectedResult = {{{2}}, {{2}}, {{2}}};

        assertThat(addTwo3DArrays(arr1, arr2))
                .hasSameDimensionsAs(arr1)
                .isDeepEqualTo(expectedResult);
    }

    @Test
    public void test4() {
        int[][][] arr1 =
            {
                {
                    {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                },
                {
                    {10, 11, 12}, {13, 14, 15}, {16, 17, 18}
                },
                {
                    {19, 20, 21}, {22, 23, 24}, {25, 26, 27}
                }
            };

        int[][][] arr2 =
            {
                {
                    {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                },
                {
                    {10, 11, 12}, {13, 14, 15}, {16, 17, 18}
                },
                {
                    {19, 20, 21}, {22, 23, 24}, {25, 26, 27}
                }
            };

        int[][][] expectedResult =
            {
                {
                    {2, 4, 6}, {8, 10, 12}, {14, 16, 18}
                },
                {
                    {20, 22, 24}, {26, 28, 30}, {32, 34, 36}
                },
                {
                    {38, 40, 42}, {44, 46, 48}, {50, 52, 54}
                }
            };

        assertThat(addTwo3DArrays(arr1, arr2))
                .hasSameDimensionsAs(arr1)
                .isDeepEqualTo(expectedResult);
    }
}
