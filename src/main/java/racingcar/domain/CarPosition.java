package racingcar.domain;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }
}