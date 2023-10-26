package racingcar.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Referee {

    private static final int MAX_VALUE = 0;
    private static final String MULTI_WINNER_DELIMITER = ", ";

    public List<Car> judgeWinner(Cars cars) {
        int maxCount = findMaxPosition(cars.getCars());

        return cars.getCars().stream()
                .filter(x -> x.getCarPosition() == maxCount)
                .toList();
    }

    private int findMaxPosition(List<Car> carList) {
        List<Integer> list = carList.stream()
                .map(Car::getCarPosition)
                .sorted(Comparator.reverseOrder())
                .toList();

        return list.get(MAX_VALUE);
    }

    public String getWinner(Cars cars) {
        return judgeWinner(cars).stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(MULTI_WINNER_DELIMITER));

    }
}
