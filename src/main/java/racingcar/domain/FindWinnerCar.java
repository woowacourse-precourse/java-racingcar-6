package racingcar.domain;

import racingcar.domain.entity.CarEntity;

import java.util.ArrayList;
import java.util.List;

public class FindWinnerCar {
    public static List<CarEntity> equalMaxScroe(List<CarEntity> cars, int maxScore) {
        List<CarEntity> winner = new ArrayList<>();
        for (CarEntity car : cars) {
            if (car.getPosition() == maxScore) {
                winner.add(car);
            }
        }
        return winner;
    }
}
