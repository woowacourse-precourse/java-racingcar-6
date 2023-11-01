package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarEngine carEngine;
    private final Position position;

    public Car(CarName name, CarEngine carEngine, Position position) {
        this.carName = name;
        this.carEngine = carEngine;
        this.position = position;
    }

    public void startEngine() {
        if (carEngine.isStart()) {
            position.goForward();
        }
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public CarEngine getCarEngine() {
        return this.carEngine;
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
