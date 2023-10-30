package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private final static int FIRST_PRIZE_CAR_INDEX = 0;


    public List<String> judgeWinners(List<Car> cars) {
        int winnerPosition = findFirstPrizeCarPosition(cars);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isLocatedIn(winnerPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int findFirstPrizeCarPosition(List<Car> cars) {
        List<Car> rankedCars = cars.stream().collect(Collectors.toList());
        Collections.sort(rankedCars);

        return rankedCars.get(FIRST_PRIZE_CAR_INDEX).getPosition();
    }
}
