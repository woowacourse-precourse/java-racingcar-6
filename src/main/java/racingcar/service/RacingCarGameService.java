package racingcar.service;

import racingcar.domain.CarNameWithPos;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumber;

import java.util.List;

public class RacingCarGameService {

    public void RacingCarGameProgress(RacingCar racingCar) {
        List<String> carNames = racingCar.getCarNames();

        for (String carName : carNames) {
            RandomNumber randomNumber = new RandomNumber();
            CarNameWithPos carNameWithPos = new CarNameWithPos(carName);

            if (randomNumber.isMovePossible()) {
                carNameWithPos.moveForward();
            }
        }
    }
}
