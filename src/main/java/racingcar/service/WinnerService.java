package racingcar.service;

import static racingcar.constant.Delimiter.WINNER_OUTPUT_COMMA;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class WinnerService {

    private static final int INIT_MAX=0;


    public String findWinners(List<Car> cars) {
        int max = INIT_MAX;
        List<String> winners = new ArrayList<>();
        max = getMaxMove(cars, max);
        makeWinnersOutput(cars, winners, max);
        return String.join(WINNER_OUTPUT_COMMA.getDelimiter(), winners);
    }

    private void makeWinnersOutput(List<Car> cars, List<String> winners, int max) {
        for (Car car : cars) {
            if (max == car.getMoveCount()) {
                winners.add(car.getName());
            }
        }
    }

    private int getMaxMove(List<Car> cars, int max) {
        for (Car car : cars) {
            max = getMax(car, max);
        }
        return max;
    }

    private int getMax(Car car, int max) {
        if (max < car.getMoveCount()) {
            max = car.getMoveCount();
        }
        return max;
    }
}
