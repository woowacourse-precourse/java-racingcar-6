package racingcar.domain;

public class CarPosition {

    private int position = 0;

    public void move(int value) {
        position = position + value;
    }

    public int getPosition() {
        return position;
    }

}
