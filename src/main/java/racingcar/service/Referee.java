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

    public String getWinnersCarName(Cars generatedCars) {
        WinnerCarResponse winner = judgeWinner(generatedCars);
        return winner.cars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(MULTI_WINNER_DELIMITER));
    }

    private WinnerCarResponse judgeWinner(Cars generatedCars) {
        int maxCount = findMaxCarPosition(generatedCars);

        List<Car> carsList = generatedCars.getCarsList().stream()
                .filter(x -> x.getCarPosition() == maxCount)
                .toList();

        return new WinnerCarResponse(carsList);
    }

    private int findMaxCarPosition(Cars cars) {
        List<Integer> list = cars.getCarsList().stream()
                .map(Car::getCarPosition)
                .sorted(Comparator.reverseOrder())
                .toList();

        return list.get(MAX_VALUE);
    }
}
