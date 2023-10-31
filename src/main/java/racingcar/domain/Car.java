package racingcar.domain;


public class Car {

    private final String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}