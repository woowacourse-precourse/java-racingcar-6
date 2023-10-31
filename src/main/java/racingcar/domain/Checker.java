package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Checker {

    public static boolean checkAtLest4(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("불가능한 값이 들어왔습니다.");
        }

        if (num >= 4) {
            return true;
        }

        return false;
    }

    public static List<Car> checkWinners(List<Car> cars) {
        int max = maxStraightCount(cars);

        return cars.stream().filter(car -> car.getStraightCount() == max).collect(Collectors.toList());
    }

    public static int maxStraightCount(List<Car> cars) {
        return cars.stream().mapToInt(car -> car.getStraightCount()).max().orElse(0);
    }
}
