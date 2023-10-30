package racingcar;

import java.util.List;


public class RacingJudge {
    public static List<String> raceJudge(List<Car> cars) {
        cars.sort(Car::compareTo);
        int max = cars.get(0).getPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .toList();
    }
}
