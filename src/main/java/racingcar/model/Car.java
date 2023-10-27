package racingcar.model;

import java.util.Objects;
import racingcar.util.MoveResolver;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance, MoveResolver moveResolver) {
        if (moveResolver.isMoveAble()) {
            position += distance;
        };
    }
}
