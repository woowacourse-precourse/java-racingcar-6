package racingcar.model;

import static racingcar.util.Constant.FORWARD_THRESHOLD;

import racingcar.util.NumberGenerator;

public class Car implements Vehicle {

    private final Name name;
    private final Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car createWith(final String name) {
        return new Car(new Name(name), Position.createDefault());
    }

    @Override
    public void move(final NumberGenerator numberGenerator) {
        if (canMove(numberGenerator)) {
            position.moveToNext();
        }
    }

    private static boolean canMove(final NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= FORWARD_THRESHOLD.getValue();
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public int getPosition() {
        return position.getCurrentSpace();
    }
}
