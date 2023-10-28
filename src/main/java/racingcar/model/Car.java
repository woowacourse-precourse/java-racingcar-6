package racingcar.model;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
    }

    public void go() {
        Engine engine = new Engine();
        if (engine.getPower() >= 4) {
            distance += 1;
        }
    }

    public String getTrace() {
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ");
        sb.append("-".repeat(Math.max(0, distance)));
        return sb.toString();
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

}
