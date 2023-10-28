package racingcar.domain;

public class Position {

    private int position;

    public void move() {

        position++;
    }

    public int getPosition() {
        return position;
    }
}
