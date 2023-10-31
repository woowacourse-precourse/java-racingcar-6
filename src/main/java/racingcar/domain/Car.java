package racingcar.domain;

public class Car {
    private final Integer MIN_NAME_LENGTH = 1;
    private final Integer MAX_NAME_LENGTH = 5;
    private final String name;
    private final Engine engine;
    private int forwardCount;

    public Car(String name) {
        checkNameLengthValid(name);
        this.name = name;
        this.engine = new Engine();
        this.forwardCount = 0;
    }

    private void checkNameLengthValid(String name) {
        if(MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void processTurn() {

    }
}
