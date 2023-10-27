package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public class RacingCarGameService {

    public int getMaxMoveNumber(List<Car> carList){
        return carList.stream()
                .mapToInt(Car::getMoveNumber)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최댓값을 찾을 수 없습니다."));
    }
}
