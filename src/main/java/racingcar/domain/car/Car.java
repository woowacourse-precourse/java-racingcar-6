package racingcar.domain.car;

import racingcar.domain.MoveCondition;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = Position.setStartPosition();
    }

    public void updatePositionBy(MoveCondition condition) {
        int distance = condition.getDistance();
        this.position.move(distance);
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.getValue();
    }
}
