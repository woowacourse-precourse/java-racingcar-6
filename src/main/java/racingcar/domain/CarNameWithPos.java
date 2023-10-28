package racingcar.domain;

public class CarNameWithPos {

    private final String carName;
    private int position;

    public CarNameWithPos(String carName) {
        this.carName = carName;
    }

    public void moveForward() {
        this.position++;
    }
}
