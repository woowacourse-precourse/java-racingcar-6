package racingcar.model;

import java.util.List;
import racingcar.util.NumberGenerator;

public record Cars(List<Car> cars) {
    public void forward(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.forward(numberGenerator));
    }

    public Cars judgeWinner() {
        int maxPosition = findMaxPosition();
        List<Car> winners = findWinners(maxPosition);
        return new Cars(winners);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
