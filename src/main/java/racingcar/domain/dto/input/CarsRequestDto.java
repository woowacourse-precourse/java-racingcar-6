package racingcar.domain.dto.input;

import racingcar.domain.Cars;
import racingcar.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public record CarsRequestDto(String carNames) {
    private static final String COMMA = ",";

    public Cars toCars() {
        validateIfIsBlank(carNames);
        return Cars.from(createCarList());
    }

    private List<String> createCarList() {
        return Arrays.stream(carNames.split(COMMA))
                .map(String::trim)
                .toList();
    }

    private void validateIfIsBlank(String input) {
        if (input.isEmpty()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
