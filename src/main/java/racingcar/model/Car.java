package racingcar.model;

import racingcar.model.dto.GameResult;
import racingcar.util.CarNameValidator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
    }

    public static Car maxByPostion(Car car1, Car car2) {
        if (car1.position > car2.position) {
            return car1;
        }
        return car2;
    }

    public boolean isSamePosition(Car target) {
        return this.position == target.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int distance, MovePolicy movePolicy) {
        if (movePolicy.isMoveAble()) {
            position += distance;
        }
    }

    public GameResult generateGameResult() {
        return new GameResult(this.getName(), this.getPosition());
    }
}
