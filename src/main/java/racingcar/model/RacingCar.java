package racingcar.model;

public class RacingCar {

    private final String carName;
    private int carLocation;

    public RacingCar(String carName) {
        this.carName = carName;
        this.carLocation = 0;
    }

    public void moveForward(int targetDistance) {
        this.carLocation += targetDistance;
    }

    public int getDistance() {
        return this.carLocation;
    }

    public String getName() {
        return this.carName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(carName);
        sb.append(" : ")
                .append("-".repeat(carLocation));
        return sb.toString();
    }
}
