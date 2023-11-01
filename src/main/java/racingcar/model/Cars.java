package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.util.NumberGenerator;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carNames) {
        cars = stringToCarList(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> stringToCarList(String carNames) {
        return Stream.of(carNames.split(DELIMITER))
                .map(Car::new)
                .toList();
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
