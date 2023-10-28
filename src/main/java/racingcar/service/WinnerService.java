package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class WinnerService {

    private static final String WINNER_OUTPUT_DELIMETER = ", ";

    public String findWinners(List<Car> cars) {
        int max=0;
        List<String> winners = new ArrayList<>();
        max = getMaxMove(cars, max);
        makeWinnersOutput(cars, max, winners);
        return String.join(WINNER_OUTPUT_DELIMETER, winners);
    }

    private void makeWinnersOutput(List<Car> cars, int max, List<String> winners) {
        for (Car car : cars) {
            if(max == car.getMoveCount()){
                winners.add(car.getName());
            }
        }
    }

    private int getMaxMove(List<Car> cars, int max) {
        for (Car car : cars) {
            max = getMax(max, car);
        }
        return max;
    }

    private int getMax(int max, Car car) {
        if(max < car.getMoveCount()){
            max = car.getMoveCount();
        }
        return max;
    }
}
