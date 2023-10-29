package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static racingcar.Constant.*;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        for (Car car : carList) {
            if (isMove()) {
                car.move();
            }
        }
    }

    private boolean isMove() {
        int number = Randoms.pickNumberInRange(START, END);
        return number >= MOVING_FORWARD;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : carList) {
            builder.append(car);
            builder.append("\n");
        }
        return builder.toString();
    }

}
