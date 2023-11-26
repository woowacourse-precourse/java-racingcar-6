package racingcar.domain;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
