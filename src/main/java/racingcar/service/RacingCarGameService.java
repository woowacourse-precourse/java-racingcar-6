package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumber;

import java.util.List;

public class RacingCarGameService {

    public void RacingCarGameProgress(RacingCar racingCar) {
        List<String> carNames = racingCar.getCarNames();

        for (int i = 0; i < carNames.size(); i++) {
            RandomNumber randomNumber = new RandomNumber();

            if (randomNumber.isMovePossible()) {

            }
        }
    }
}
