package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private static final String DELIMITER = ",";

    private final List<CarName> carNames;

    private CarNames(String input) {
        List<String> seperatedInput = Arrays.asList(input.split(DELIMITER));
        validate(seperatedInput);
        carNames = seperatedInput.stream().map(CarName::create).toList();
    }

    public static CarNames create(String input) {
        return new CarNames(input);
    }

    private static void validate(List<String> seperatedInput) {
        long distinctCount = seperatedInput.stream().distinct().count();
        if (seperatedInput.size() != distinctCount) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getCarNames() {
        return carNames.stream().map(CarName::getCarName).toList();
    }
}
