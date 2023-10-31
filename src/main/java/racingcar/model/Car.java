package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {

    private static final int MIN_MOVE_STANDARD = 4;

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
        if (canMove(number)) {
            position.move();
        }
    }

    private boolean canMove(final int number) {
        return number >= MIN_MOVE_STANDARD;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
