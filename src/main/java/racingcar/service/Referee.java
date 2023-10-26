package racingcar.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.WinnerCarResponse;

public class Referee {

    private static final int MAX_VALUE = 0;
    private static final String MULTI_WINNER_DELIMITER = ", ";

    public WinnerCarResponse judgeWinner(Cars cars) {
        int maxCount = findMaxPosition(cars);

        List<Car> carsList = cars.getCars().stream()
                .filter(x -> x.getCarPosition() == maxCount)
                .toList();

        return new WinnerCarResponse(carsList);
    }

    private int findMaxPosition(Cars cars) {
        List<Integer> list = cars.getCars().stream()
                .map(Car::getCarPosition)
                .sorted(Comparator.reverseOrder())
                .toList();

        return list.get(MAX_VALUE);
    }

    public String getWinner(Cars cars) {
        WinnerCarResponse winnerCarResponse = judgeWinner(cars);
        return winnerCarResponse.cars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(MULTI_WINNER_DELIMITER));
    }
}
