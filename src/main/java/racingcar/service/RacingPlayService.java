package racingcar.service;

import static racingcar.enums.Integers.MIN_FORWARD_CONDITION;
import static racingcar.enums.Integers.RANDOM_NUMBER_MAX;
import static racingcar.enums.Integers.RANDOM_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingPlayService {

    CarRepository carRepository = CarRepository.getInstance();

    public void playRacing() {
        carRepository.findAll();

    }

    public boolean checkMoveForward() {
        if (isCarMoveForward()) {
            return true;
        }
        return false;
    }

    private boolean isCarMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.show(), RANDOM_NUMBER_MAX.show());

        return randomNumber >= MIN_FORWARD_CONDITION.show();
    }

}
