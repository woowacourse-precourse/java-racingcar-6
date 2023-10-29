package racingcar.model;

import racingcar.util.CarNameValidator;
import racingcar.util.MoveResolver;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
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
        }
    }

    public GameResult generateGameResult() {
        return new GameResult(this.getName(), this.getPosition());
    }
}
