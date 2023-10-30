package racingcar.domain;

import racingcar.domain.entity.CarEntity;

import java.util.List;

public class FindMaxScore {
    public static int FindMax(List<CarEntity> cars) {
        int maxScore = -1;
        for (CarEntity car : cars) {
            if (car.getPosition() > maxScore) {
                maxScore = car.getPosition();
            }
        }
        return maxScore;
    }
}
