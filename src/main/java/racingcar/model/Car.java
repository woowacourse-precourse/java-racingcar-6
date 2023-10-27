package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {

    private final Name name;
    private final Position position;

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(final NumberGenerator generator) {
        int number = generator.generate();
        position.move(number);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
