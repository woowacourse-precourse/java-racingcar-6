package racingcar.model;

import racingcar.exception.ErrorMessage;

public class Car {
    private static final int FORWARD_LOWER_INCLUSIVE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final NumberGenerator generator;
    private int step;

    public Car(String name, NumberGenerator generator) {
        validateLength(name);
        this.name = name;
        this.step = 0;
        this.generator = generator;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void moveOneStep() {
        if (generator.generate() >= FORWARD_LOWER_INCLUSIVE) {
            step++;
        }
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public boolean compare(int maxStep){
        return step == maxStep;
    }

}
