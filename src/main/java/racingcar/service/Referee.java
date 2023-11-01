package racingcar.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.IntegerConstant;
import racingcar.domain.StringConstant;
import racingcar.dto.WinnerCarResponse;

public class Referee {


    public String getWinnersCarName(Cars generatedCars) {
        WinnerCarResponse winner = judgeWinner(generatedCars);
        return winner.cars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(StringConstant.MULTI_WINNER_DELIMITER.getMessage()));
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

        return list.get(IntegerConstant.MAX_CAR_POSITION.getValue());
    }
}
