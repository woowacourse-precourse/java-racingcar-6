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

    public String getRoundResults(List<Car> cars) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(getCarStatus(car));
        }
        return String.join("\n", result);
    }

    private String getCarStatus(Car car) {
        String progressBar = AppConstants.POSITION_PROGRESS_BAR.repeat(Math.max(0, car.getPosition()));
        return String.join(" : ", car.getName(), progressBar);
    }
}
