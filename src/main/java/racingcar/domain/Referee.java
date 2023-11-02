package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private final static int FIRST_PRIZE_CAR_INDEX = 0;


    public Winners judgeWinners(List<Car> cars) {
        int winnerPosition = findFirstPrizeCarPosition(cars);

        List<Car> winningCars = cars.stream()
                .filter(car -> car.isLocatedIn(winnerPosition))
                .toList();

        return new Winners(winningCars);
    }

    private int findFirstPrizeCarPosition(List<Car> cars) {
        List<Car> rankedCars = cars.stream().collect(Collectors.toList());
        Collections.sort(rankedCars);

        return rankedCars.get(FIRST_PRIZE_CAR_INDEX).getPosition();
    }
}
