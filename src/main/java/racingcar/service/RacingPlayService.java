package racingcar.service;

import static racingcar.constants.Integers.MIN_FORWARD_CONDITION;
import static racingcar.constants.Integers.RANDOM_NUMBER_MAX;
import static racingcar.constants.Integers.RANDOM_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;

public class RacingPlayService {


    public void playRacingWith(RacingCars racingCars) {
        List<Car> cars = racingCars.showRacingCars();
        cars.forEach(this::checkMoveForward);
    }

    public void checkMoveForward(Car car) {
        if (isCarMoveForward()) {
            car.moveForward();
        }

    }

    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.show(), RANDOM_NUMBER_MAX.show());

        return randomNumber >= MIN_FORWARD_CONDITION.show();
    }

}
