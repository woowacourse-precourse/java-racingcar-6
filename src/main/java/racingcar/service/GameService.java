package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public class GameService {
    /**
     * 최대로 움직인 횟수 탐색
     */
    private int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}
