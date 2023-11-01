package racingcar.model;

import java.util.List;
import racingcar.util.NumberGenerator;

public record Cars(List<Car> cars) {
    public void forward(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.forward(numberGenerator));
    }

    public Cars judgeWinner() {
        int maxPoint = findMaxPoint();
        List<Car> winners = findWinners(maxPoint);
        return new Cars(winners);
    }

    private int findMaxPoint() {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    private List<Car> findWinners(int maxPoint) {
        return cars.stream()
                .filter(car -> car.getPoint() == maxPoint)
                .toList();
    }
}
