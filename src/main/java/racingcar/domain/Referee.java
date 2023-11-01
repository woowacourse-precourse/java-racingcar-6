package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private final static int JUDGE_STANDARD = 4;

    public boolean isGreaterThanEqual(int number) {
        return number >= JUDGE_STANDARD;
    }

    public List<String> judgeWinner(List<Car> carList) {
        Car winner = Collections.max(carList);
        int maxLocation = winner.getLocation();
        return carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
