package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.AppConstants;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameProgressService {

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if ( shouldCarMove()) {
                car.addPosition();
            }
        }
    }
    private boolean shouldCarMove() {
        int random = generateRandomNumber();
        return random >= AppConstants.FORWARD_CONDITION;
    }
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(AppConstants.RANDOM_BEGIN_RANGE, AppConstants.RANDOM_END_RANGE);
    }
}
