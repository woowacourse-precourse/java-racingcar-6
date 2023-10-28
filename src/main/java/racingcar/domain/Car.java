package racingcar.domain;

public class Car {
    private final String name;
    private final CarEngine carEngine;
    private final Position position;

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

    public String getName() {
        return this.name;
    }

    public CarEngine getCarEngine() {
        return this.carEngine;
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
