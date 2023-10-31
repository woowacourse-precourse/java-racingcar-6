package racingcar.domain;

import racingcar.utils.Constants;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(Constants.START_POSITION);
    }

    public int move(int random) {
        if (random >= Constants.THRESHOLD_VALUE) {
            position.addPosition();
        }
        return position.getPosition();
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.getPosition() >= maxPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
