package racingcar.domain;

public class Move {
    private StringBuilder move;

    public Move() {
        this.move = new StringBuilder();
    }

    public void increase() {
        move.append("-");
    }

    public void print() {
        System.out.print(move.toString());
    }

    public int getMoveCount() {
        return move.length();
    }

    @Override
    public String toString() {
        return move.toString();
    }
}
