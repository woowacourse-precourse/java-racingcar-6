package racingcar.domain;

import racingcar.exception.CarNameException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static racingcar.exception.CarNameException.validateCarNameDuplicate;

public class Cars {
    private final static String NEW_LINE = "\n";
    private final static int DEFAULT_MAX_POS = 0;
    private static final String WINNER_NAMES_REGEX = ", ";

    private final List<Car> cars;

    public Cars(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(toList());
        validateCarNameDuplicate(names);
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            String curState = car.getCurState();
            result.append(curState);
            result.append(NEW_LINE);
        }
        return result.toString();
    }

    public String getWinner() {
        int maxPos = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPos))
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAMES_REGEX));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_MAX_POS);
    }

}
