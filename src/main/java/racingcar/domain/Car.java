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

    public String getCarName() {
        return this.carName;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public String getMovingTrace() {
        return this.movingTrace.toString();
    }

    public String toString() {
        return getCarName() + " : " + getMovingTrace();
    }


}
