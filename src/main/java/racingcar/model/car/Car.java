package racingcar.model.car;

import racingcar.model.car.dto.GameResult;
import racingcar.model.movepolicy.MovePolicy;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this.carName = new CarName(name);
        this.position = position;
    }

    public static Car maxByPostion(final Car car1, final Car car2) {
        if (car1.position > car2.position) {
            return car1;
        }
        return car2;
    }

    public boolean isSamePosition(final Car target) {
        return this.position == target.position;
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position;
    }

    public void move(final int distance, final MovePolicy movePolicy) {
        if (movePolicy.isMoveAble()) {
            position += distance;
        }
    }

    public GameResult generateGameResult() {
        return new GameResult(this.getName(), this.getPosition());
    }
}
