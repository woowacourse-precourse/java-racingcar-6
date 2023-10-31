package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Cars {

    public static List<String> getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            getWinnersCar(car, maxPosition, winners);
        }
        return winners;
    }

    private static List<String> getWinnersCar(Car car, int maxPosition, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
        return winners;
    }
}
