package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<String> judgeWinner(List<Car> cars) {
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

        return rankedCars.get(0).getPosition();
    }
}
