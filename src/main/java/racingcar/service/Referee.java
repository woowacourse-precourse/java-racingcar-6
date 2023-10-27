package racingcar.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.CarsGenerateDto;
import racingcar.dto.WinnerCarResponse;

public class Referee {

    private static final int MAX_VALUE = 0;
    private static final String MULTI_WINNER_DELIMITER = ", ";

    public WinnerCarResponse judgeWinner(CarsGenerateDto carsGenerateDto) {
        int maxCount = findMaxPosition(carsGenerateDto);

        List<Car> carsList = carsGenerateDto.cars().stream()
                .filter(x -> x.getCarPosition() == maxCount)
                .toList();

        return new WinnerCarResponse(carsList);
    }

    private int findMaxPosition(CarsGenerateDto generatedCars) {
        List<Integer> list = generatedCars.cars().stream()
                .map(Car::getCarPosition)
                .sorted(Comparator.reverseOrder())
                .toList();

        return list.get(MAX_VALUE);
    }

    public String getWinnersCarName(CarsGenerateDto generatedCars) {
        WinnerCarResponse winner = judgeWinner(generatedCars);
        return winner.cars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(MULTI_WINNER_DELIMITER));
    }
}
