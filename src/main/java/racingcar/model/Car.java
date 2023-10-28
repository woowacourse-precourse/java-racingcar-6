package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {

    private final Name name;
    private final Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String value) {
        Name name = Name.from(value);
        Position position = Position.createDefault();
        return new Car(name, position);
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
