package com.skahhong.playground.dsaj;

import com.skahhong.playground.datastructures.SinglyLinkedList;

public class ScoreboardSinglyLinkedList {
    private int numEntries = 0;
    private static final int maxEntries = 5;
    private SinglyLinkedList<GameEntry> board;

    public ScoreboardSinglyLinkedList() {
        board = new SinglyLinkedList<GameEntry>();
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        /*
        Do we even need to put the new score into the highscore board?
         */
        if(board.isEmpty()) {
            board.addFirst(e);
            numEntries++;

        } else if(numEntries < maxEntries || newScore > board.last().getScore()) {
            // no need to remove existing nodes
            if(numEntries < maxEntries) {
                numEntries++;

            } else {
                // last score is evicted from the scoreboard
                board.removeLast();
            }

            // A list of existing nodes we will eventually add it behind the new node
            SinglyLinkedList<GameEntry> removedEntries = new SinglyLinkedList<>();

            while(board.last() != null && newScore > board.last().getScore()) {
                removedEntries.addFirst(board.last());
                board.removeLast();
            }

            // add the new node
            board.addLast(e);

            // add back the existing nodes that are smaller than the new node
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
