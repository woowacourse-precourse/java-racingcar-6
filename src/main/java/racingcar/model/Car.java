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

}
