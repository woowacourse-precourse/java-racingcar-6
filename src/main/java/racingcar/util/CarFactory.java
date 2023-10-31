package racingcar.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.Car;

public class CarFactory {

    private static final int MAX_CAR_COUNT = 10;

    private static final Pattern carNamePattern;
    private static Matcher matcher;

    static {
        carNamePattern = Pattern.compile("^[a-z]*$");
    }

    public static List<Car> createCars(String carNamesInput) {

        validateNullAndEmpty(carNamesInput);

        String[] carNames = carNamesInput.replaceAll(" ", "").split(",");
        validateCarSize(carNames.length);

        List<Car> cars = new ArrayList<>();
        Set<String> duplicateNameSet = new HashSet<>();

        for (int i = 0; i < carNames.length; i++) {
            validateInputFormat(carNames[i]);

            duplicateNameSet.add(carNames[i]);
            if (duplicateNameSet.size() != cars.size() + 1) {
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATE);
            }

            cars.add(new Car(carNames[i]));
        }

        return cars;
    }

    private static void validateNullAndEmpty(String carNamesInput) {

        if (Objects.isNull(carNamesInput)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY);
        }

        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY);
        }
    }

    private static void validateInputFormat(String input) {

        Matcher matcher = carNamePattern.matcher(input);

        boolean isValid = matcher.find();
        if (!isValid) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_FORMAT);
        }
    }

    private static void validateCarSize(int size) {
        if (size > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_SIZE);
        }
    }
}
