package racingcar.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;

public class WinnerChecker {
    public static List<Car> findWinner(List<Car> carList) {
        return carList.stream()
                .filter(i ->
                        i.getProgressToInt() == carList.stream()
                                .mapToInt(Car::getProgressToInt)
                                .max()
                                .getAsInt())
                .collect(toList());
        //TODO 2023 10 27 2중 스트림 간소화 필요함
    }
}
