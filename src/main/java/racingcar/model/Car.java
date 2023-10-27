package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(NumberGenerator generator) {
        int number = generator.generate();
        position.move(number);
    }
}
