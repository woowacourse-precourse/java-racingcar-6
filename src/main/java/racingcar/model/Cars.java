package racingcar.model;

import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forward(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.forward(numberGenerator));
    }

    public Cars judgeWinner() {
        int maxPoint = findMaxPoint();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPoint() == maxPoint)
                .toList();
        return new Cars(winners);
    }

    private int findMaxPoint() {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public List<Car> getCars() {
        return cars;
    }
}
