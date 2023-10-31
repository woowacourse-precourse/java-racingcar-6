package racingcar.controller.subcontroller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.util.Util;

public class DetermineWinnerController {
    public List<String> determineWinner() {
        int maxCount = getMaxCount();
        return CarRepository.cars()
                .stream()
                .filter(car -> Util.isEqual(maxCount, car.getMoveCount()))
                .map(Car::getName)
                .toList();
    }

    private int getMaxCount() {
        int maxCount = -1;
        for (Car car : CarRepository.cars()) {
            maxCount = Math.max(car.getMoveCount(), maxCount);
        }
        return maxCount;
    }
}
