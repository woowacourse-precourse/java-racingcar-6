package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private static final String DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(String carNamesString) {
        carNames = validate(splitInput(carNamesString)).stream()
                .map(CarName::create)
                .toList();
    }

    public static CarNames create(String input) {
        return new CarNames(input);
    }

    private List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    private List<String> validate(List<String> seperatedInput) {
        long distinctCount = seperatedInput.stream().distinct().count();
        if (seperatedInput.size() != distinctCount) {
            throw new IllegalArgumentException();
        }
        return seperatedInput;
    }

    protected List<String> getCarNames() {
        return carNames.stream().map(CarName::getCarName)
                .toList();
    }
}
