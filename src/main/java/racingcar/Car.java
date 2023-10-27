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

    public Car(String name, CarEngine carEngine, Position position) {
        this.name = name;
        this.carEngine = carEngine;
        this.position = position;
    }

    public void startEngine() {
        if (carEngine.isStart()) {
            position.goForward();
        }
    }

    String getName() {
        return this.name;
    }

    CarEngine getCarEngine() {
        return this.carEngine;
    }

    int getPosition() {
        return this.position.getValue();
    }
}
