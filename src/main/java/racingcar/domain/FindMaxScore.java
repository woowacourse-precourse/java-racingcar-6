package racingcar.domain;

import racingcar.domain.entity.CarEntity;

import java.util.List;

public class FindMaxScore {
    public static int findMax(List<CarEntity> cars) {
        int maxScore = -1;
        for (CarEntity car : cars) {
            if (car.getPosition() > maxScore) {
                maxScore = car.getPosition();
            }
        }
        return maxScore;
    }
}
