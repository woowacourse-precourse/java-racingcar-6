package racingcar.domain;

import static racingcar.constant.GameNumber.MOVE_NUMBER;
import static racingcar.constant.GameNumber.RANDOM_NUMBER_MAXIMUM;
import static racingcar.constant.GameNumber.RANDOM_NUMBER_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Movement {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
    }

    public boolean isMoveForward() {
        return createRandomNumber() >= MOVE_NUMBER;
    }

    public void moveCar(List<Car> cars) {
        for (Car car : cars) {
            if (isMoveForward()) {
                car.move();
            }
        }
    }
}
