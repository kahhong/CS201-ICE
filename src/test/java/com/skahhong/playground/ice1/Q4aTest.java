package com.skahhong.playground.ice1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Q4aTest {

    @Test
    public void arrayWithLessThan6Elements() {
        int[] array = {1};

        assertThat(Q4a.findRepeated(array)).isEqualTo(0);
    }

    @Test
    public void arrayWith6Elements() {
        int[] array = {1, 1, 1, 1, 1, 1, 2};

        assertThat(Q4a.findRepeated(array)).isEqualTo(1);
    }

    @Test
    public void arrayWith7Elements() {
        int[] array = {3, 3, 3, 3, 3, 1, 2, 3};

        assertThat(Q4a.findRepeated(array)).isEqualTo(3);
    }

    @Test
    public void arrayWith10Elements() {
        int[] array = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5};

        assertThat(Q4a.findRepeated(array)).isEqualTo(5);
    }
}