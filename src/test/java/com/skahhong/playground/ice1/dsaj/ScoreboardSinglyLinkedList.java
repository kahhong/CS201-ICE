package com.skahhong.playground.ice1.dsaj;

import com.skahhong.playground.ice1.datastructures.SinglyLinkedList;

public class ScoreboardSinglyLinkedList {
    private int numEntries = 0;
    private int maxEntries = 5;
    private SinglyLinkedList<GameEntry> board;

    public ScoreboardSinglyLinkedList() {
        board = new SinglyLinkedList<GameEntry>();
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        /*
        Do we even need to put the new score into the highscore board?
         */
        if(numEntries < maxEntries) {
            // A placeholder to store the nodes we will eventually add it behind the new node
            SinglyLinkedList<GameEntry> removedEntries = new SinglyLinkedList<>();

            while(board.last() != null && newScore > board.last().getScore()) {
                removedEntries.addFirst(board.last());
                board.removeLast();
            }

            board.addLast(e);
            numEntries++;

            while(removedEntries.first() != null) {
                board.addLast(removedEntries.first());
                removedEntries.removeFirst();
            }
            return;

        } else if (newScore > board.last().getScore()) {
            // last score is evicted from the scoreboard
            board.removeLast();

            // A placeholder to store the nodes we will eventually add it behind the new node
            SinglyLinkedList<GameEntry> removedEntries = new SinglyLinkedList<>();

            // remove all the scores lower than the new score
            while(newScore > board.last().getScore()) {
                removedEntries.addFirst(board.last());
                board.removeLast();
            }

            board.addLast(e);

            // add the lower scores back behind the new score
            while(removedEntries.first() != null) {
                board.addLast(removedEntries.first());
                removedEntries.removeFirst();
            }
        }
    }

    public String toString() {
        return board.toString();
    }
}
