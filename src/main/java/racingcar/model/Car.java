package racingcar.model;

import racingcar.model.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int location;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveIfPossible() {
        if (moveStrategy.shouldMove()) {
            location++;
        }
    }
}
