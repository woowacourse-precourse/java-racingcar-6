package racingcar.service;

import racingcar.constants.AppConstants;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameResultService {

    public String getFinalWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return String.join(AppConstants.INPUT_DELIMITER, winners);
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

}
