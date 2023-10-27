package racingcar.service;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameService {

    public int getMaxMoveNumber(List<Car> carList){
        return carList.stream()
                .mapToInt(Car::getMoveNumber)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최댓값을 찾을 수 없습니다."));
    }

    public List<String> getWinnerNames(List<Car> carList, int maxMoveNumber){
        return carList.stream()
                .filter(car -> car.isMaxMoveNumber(maxMoveNumber))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
