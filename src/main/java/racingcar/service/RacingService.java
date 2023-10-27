package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarGarage;

public class RacingService {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int STANDARD = 4;

    public void race(CarGarage garage) {
        for (Car car : garage.cars()) {
            boolean isGo = checkRacingCondition();
            if (isGo) {
                car.goForward();
            }
        }
    }

    private boolean checkRacingCondition() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= STANDARD;
    }
}
