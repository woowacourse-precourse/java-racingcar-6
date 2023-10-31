package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    // 우승자 목록
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
