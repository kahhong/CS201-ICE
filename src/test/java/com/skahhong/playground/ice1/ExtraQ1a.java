package com.skahhong.playground.ice1;

import com.skahhong.playground.dsaj.GameEntry;
import com.skahhong.playground.dsaj.ScoreboardSinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtraQ1a {

    @Test
    public void testAdd() {
        ScoreboardSinglyLinkedList highscores = new ScoreboardSinglyLinkedList();

        String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
        int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

        for (int i=0; i < names.length; i++) {
            GameEntry gE = new GameEntry(names[i], scores[i]);
            System.out.println("Adding " + gE);
            highscores.add(gE);
            System.out.println(" Scoreboard: " + highscores);
        }

        assertThat(highscores.toString()).isEqualTo("((Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660))");
    }

    @Test
    public void testRemove() {
        ScoreboardSinglyLinkedList highscores = new ScoreboardSinglyLinkedList();

        String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
        int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

        for (int i=0; i < names.length; i++) {
            GameEntry gE = new GameEntry(names[i], scores[i]);
            System.out.println("Adding " + gE);
            highscores.add(gE);
            System.out.println(" Scoreboard: " + highscores);
        }

        assertThat(highscores.toString()).isEqualTo("((Mike, 1105), (Rob, 750), (Jill, 740), (Paul, 720), (Anna, 660))");
    }

    @Test
    public void testToString() {

    }
}
