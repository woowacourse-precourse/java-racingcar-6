package racingcar.domain.dto.input;

import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

public record CarsDto(String carNames) {
    private static final String COMMA = ",";
    private static final String REMOVE_WHITESPACE = "\\s+";

    public Cars toCars() {
        return Cars.from(createCarList());
    }

    private List<String> createCarList() {
        return Arrays.stream(getSplit())
                .toList();
    }

    private String[] getSplit() {
        return carNames.replaceAll(REMOVE_WHITESPACE, "")
                .split(COMMA);
    }
}
