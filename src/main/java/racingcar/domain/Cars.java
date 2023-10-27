package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private final List<Car> cars;

    public Cars(List<String> names) {
        validate(names);
        cars = convertToCars(names);
    }

    private List<Car> convertToCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        checkDuplicate(names);
        checkComma(names);
    }

    private void checkComma(List<String> names) {
        if (hasComma(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasComma(List<String> names) {
        long count = names.stream()
                .filter(name -> name.contains(","))
                .count();

        return count != 0;
    }

    private void checkDuplicate(List<String> names) {
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<String> names) {
        long count = names.stream()
                .distinct()
                .count();

        return names.size() != count;
    }
}
