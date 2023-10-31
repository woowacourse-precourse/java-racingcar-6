package racingcar.model.car;

import racingcar.model.movepolicy.MovePolicy;
import racingcar.model.car.dto.GameResult;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = position;
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
        return carName.getCarName();
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
