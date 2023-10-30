package racingcar.model;

public class Car {
    final static int START_POSITION = 0;
    public String carName;
    public int carPosition = START_POSITION;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = START_POSITION;
    }
}
