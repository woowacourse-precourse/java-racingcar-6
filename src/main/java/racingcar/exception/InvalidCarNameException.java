package racingcar.exception;

import java.util.List;
import racingcar.domain.Car;

public class InvalidCarNameException extends IllegalArgumentException {

    private static final String LENGTH_EXCEED_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_FORMAT_MESSAGE = "자동차 이름은 콤마(,)로 구분된 형태여야 합니다.";
    private static final String DUPLICATE_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    public InvalidCarNameException() {
        super();
    }

    public InvalidCarNameException(String message) {
        super(message);
    }

    public static void validateNameLength(String namesString) {
        String[] names = namesString.split(",");
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new InvalidCarNameException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }

    public static void validateUniqueNames(List<Car> cars) {
        List<String> names = cars.stream().map(Car::getName).toList();
        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new InvalidCarNameException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
