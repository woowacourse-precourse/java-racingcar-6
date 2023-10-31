package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private final static int JUDGE_STANDARD = 4;

    public boolean isGreaterThanEqual(int number) {
        return number >= JUDGE_STANDARD;
    }

    public List<String> judgeWinner(List<Car> carList) {
        int max = carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getLocation() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
