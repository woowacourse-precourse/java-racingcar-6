package racingcar.exception;

import java.util.List;
import racingcar.domain.Car;

public class InvalidCarNameException extends IllegalArgumentException {


    private static final int MAX_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEED_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String DUPLICATE_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    public InvalidCarNameException() {
        super();
    }

    public InvalidCarNameException(String message) {
        super(message);
    }

    public static void validate(List<Car> cars) {
        validateNameLength(cars);
        validateUniqueNames(cars);
    }

    private static void validateNameLength(List<Car> cars) {
        List<String> names = cars.stream().map(Car::getName).toList();
        for (String name : names) {
            if (name.trim().length() > MAX_NAME_LENGTH) {
                throw new InvalidCarNameException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }

    private static void validateUniqueNames(List<Car> cars) {
        List<String> names = cars.stream().map(Car::getName).toList();
        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new InvalidCarNameException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
