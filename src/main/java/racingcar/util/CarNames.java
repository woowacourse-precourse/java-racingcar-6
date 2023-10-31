package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private static final String COMMA_DELIMITER = ",";
    private static final String EXCEPTION_MESSAGE = "유효하지않은 입력입니다.";

    private final String value;

    public CarNames(String carName) {
        hasNotNUllEmpty(carName);
        this.value = carName;
    }

    public List<String> extractCarNames() {
        String[] names = value.split(COMMA_DELIMITER);
        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void hasNotNUllEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
