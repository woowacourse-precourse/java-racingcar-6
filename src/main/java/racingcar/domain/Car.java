package racingcar.domain;

public class Car {
    private final String carName;
    private final StringBuilder forward;

    public Car(String carName) {
        this.carName = carName;
        this.forward = new StringBuilder();
    }

    public void isForward() {

    }

    @Override
    public String toString() {

        return null;
    }

    public int getForwardSize() {
        return this.forward.length();
    }

    public String getCarName() {
        return this.carName;
    }
}
