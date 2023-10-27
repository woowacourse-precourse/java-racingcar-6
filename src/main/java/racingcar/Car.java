package racingcar;

public class Car {
    private final String name;
    private final CarEngine carEngine;
    private Position position;

    public Car(String name, CarEngine carEngine) {
        this.name = name;
        this.carEngine = carEngine;
        this.position = new Position();
    }

    public void startEngine() {
        if (carEngine.start()) {
            position.goForward();
        }
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
