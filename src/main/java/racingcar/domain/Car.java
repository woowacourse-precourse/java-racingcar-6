package racingcar.domain;

public class Car {
    private final static char CAR_MOVING_TRACE = '-';
    private final String carName;
    private int movingDistance = 0;
    private StringBuilder movingTrace = new StringBuilder("");

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForward() {
        this.movingDistance++;
        this.movingTrace.append(CAR_MOVING_TRACE);
    }

    public String toStringCarName() {
        return this.carName;
    }

    public String toStringMovingTrace() {
        return this.movingTrace.toString();
    }

    public String toString() {
        return toStringCarName() + " : " + toStringMovingTrace();
    }

}
