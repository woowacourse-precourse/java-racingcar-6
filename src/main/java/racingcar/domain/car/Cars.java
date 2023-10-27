package racingcar.domain.car;

import static racingcar.domain.car.NameRule.NAME_DUPLICATED;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> input) {
        validate(input);
        this.cars = input;
    }

    public static Cars asCars(List<Car> input) {
        return new Cars(input);
    }

    private void validate(List<Car> input) {
        if (isDuplicated(input)) {
            throw new IllegalArgumentException(NAME_DUPLICATED);
        }
    }

    private boolean isDuplicated(List<Car> input) {
        return input.size() != input.stream()
                .distinct()
                .count();
    }
}
