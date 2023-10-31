package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.system.SystemConstant;

public final class CarMover {

    public static void move(List<Car> carList) {
        carList.stream()
                .filter(i -> isMoving())
                .forEach(Car::move);
    }

    private static boolean isMoving() {
        return Randoms.pickNumberInRange(
                SystemConstant.MIN_RANDOM_CONSTANT.getValue(), SystemConstant.MAX_RANDOM_CONSTANT.getValue())
                >= SystemConstant.MOVE_STANDARD.getValue();
    }
}
