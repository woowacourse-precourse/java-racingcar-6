package racingcar.model;

public class Car {

    private final String carName;
    private int forwardNumber;

    public Car(String carName) {
        this.carName = carName;
        forwardNumber = 0;
    }

    public String getcarName() {
        return carName;
    }

    public int getForwardNumber() {
        return forwardNumber;
    }

    public void increaseForwardNumber() {
        forwardNumber++;
    }
}
