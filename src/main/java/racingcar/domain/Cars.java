package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.CarNameValidator.*;

public class Cars {
    private static final String COMMA = ",";

    private final List<Car> racingCars;

    // Cars Constructor
    private Cars(final String input) {
        validateNull(input);
        validateWhiteSpace(input);
        validateEndsWithTab(input);
        validateEndsWithComma(input);
        validateEndsWithNewLine(input);

        List<String> carNames = parseInput(input);
        this.racingCars = createCars(carNames);
    }

    // Cars Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }

    private static List<String> parseInput(final String input) {
        return Arrays.stream(input.split(COMMA))
                .toList();
    }
}
