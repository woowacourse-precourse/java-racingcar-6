package racingcar.domain;

public class Move {
    private StringBuilder move;

    public Move() {
        this.move = new StringBuilder();
    }

    public void increaseMove() {
        move.append("-");
    }

    public void print() {
        System.out.print(move.toString());
    }
}
