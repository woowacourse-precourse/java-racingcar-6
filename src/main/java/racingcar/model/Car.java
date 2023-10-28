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
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
