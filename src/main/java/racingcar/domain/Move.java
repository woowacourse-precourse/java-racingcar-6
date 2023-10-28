package racingcar.domain;

public class Move {
    private int move;

    public Move(int move) {
        this.move = move;
    }

    public void increaseMove() {
        move++;
    }
}
