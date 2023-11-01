package model;

public class Place {
    int moveCount;

    public void moveForward() {
        this.moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
