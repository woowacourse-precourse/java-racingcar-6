package racingcar.domain;

public class Car {
    private final String name;
    private final Engine engine;
    private int forwardCount;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = new Engine();
        this.forwardCount = 0;
    }

    private Boolean isNameLengthValid() {
        return false;
    }

    private void processTurn() {

    }
}
