package racingcar.domain;

public class Car {

    private static final int START_LINE = 0;

    private final String carName;
    private int location;

    public Car(String carName) {
        this.carName = carName;
        this.location = START_LINE;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        this.location++;
    }
}
