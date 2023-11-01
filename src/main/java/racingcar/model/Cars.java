package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Parser;

public class Cars {
    private List<Car> cars;
    private final Parser parser = new Parser();

    public Cars(String carNames) {
        validateCarNamesDuplicate(carNames);
        cars = parser.parseCarNames(carNames)
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(Car::moveByCondition);
    }

    public String toString() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateCarNamesDuplicate(String carNames) {
        List<String> carNameList = parser.parseCarNames(carNames);
        boolean hasDuplicate = carNameList.stream()
                .anyMatch(e -> Collections.frequency(carNameList, e) > 1);
        if (hasDuplicate) {
            throw new IllegalArgumentException();
        }
    }


}
