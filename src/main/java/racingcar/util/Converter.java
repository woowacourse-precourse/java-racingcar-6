package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Converter {
    private static final int LENGTH_LIMITER = 5;
    private static final String DELIMITER = ",";
    private static final String SINGLE_BLANK = " ";
    private static final String COLON = ":";
    private static final String HYPHEN = "-";
    private static final String NEWLINE = "\n";

    public static Cars parseCarNames(String carNames) {
        List<Car> cars = Stream.of(carNames.split(DELIMITER))
                .peek(Converter::validateLength)
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public static String formatCarsResult(Cars cars) {
        return cars.getCars().stream()
                .map(Converter::formatCarResult)
                .collect(Collectors.joining(NEWLINE));
    }

    public static String formatWinnersResult(Cars cars) {
        return cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER + SINGLE_BLANK));
    }

    private static void validateLength(String name) {
        if (name.length() > LENGTH_LIMITER) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
        }
    }

    private static String formatCarResult(Car car) {
        return car.getName() + SINGLE_BLANK + COLON + SINGLE_BLANK + HYPHEN.repeat(car.getPoint());
    }
}
