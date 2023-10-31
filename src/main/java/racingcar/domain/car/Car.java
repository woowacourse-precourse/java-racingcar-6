package racingcar.domain.car;

import racingcar.domain.racing.MoveStrategy;

public class Car {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (moveStrategy.move()) {
            position += 1;
        }
    }
}
