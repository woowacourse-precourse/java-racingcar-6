package racingcar.domain;

import java.util.List;

import static racingcar.domain.Validator.*;

public class Cars {
    private final List<Car> racingCars;

    // Car Constructor
    private Cars(final String input) {
        // Validate Invalid String Input
        validateNull(input);
        validateContainTab(input);
        validateContainNewLine(input);
        validateContainWhiteSpace(input);
        validateEndsWithComma(input);

        // Validate carName Length
        List<String> carNames = Parser.parseInput(input);
        validateNameLength(carNames);

        // Construct Cars Entity
        this.racingCars = createCars(carNames);
    }

    // Cars Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    // 경주할 자동차를 1회전 전진시킨다.
    public static void playOneRotation() {
    }


    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }
}
