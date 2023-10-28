package racingcar.model;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }
}
