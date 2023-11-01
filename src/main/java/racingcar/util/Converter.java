package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Converter {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String SINGLE_BLANK = " ";
    private static final String COLON = ":";
    private static final String HYPHEN = "-";
    private static final String NEWLINE = "\n";

    public static Cars parseCars(String carNames) {
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
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름을 1글자 이상 입력해주세요");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름을 5글자 이하로 입력해주세요");
        }
    }

    private static String formatCarResult(Car car) {
        return car.getName() + SINGLE_BLANK + COLON + SINGLE_BLANK + HYPHEN.repeat(car.getPosition());
    }
}
