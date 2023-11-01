package domain;

import static constant.ConstantNumber.DEFAULT_MAX_MOVE_COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<String> winners;

    public Winners(List<Car> carsList) {
        int maxCount = findMaxMoveCount(carsList);

        winners = carsList.stream()
                .filter(car -> car.getMoveCount() == maxCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxMoveCount(List<Car> carsList) {
        int maxMoveCount = DEFAULT_MAX_MOVE_COUNT.getValue();

        for (Car car : carsList) {
            int moveCount = car.getMoveCount();
            if (moveCount > maxMoveCount) {
                maxMoveCount = moveCount;
            }
        }
        return maxMoveCount;
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
