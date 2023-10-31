package racingcar.domain.dto.input;

import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

public record CarsRequestDto(String carNames) {
    private static final String COMMA = ",";

    public Cars toCars() {
        return Cars.from(createCarList());
    }

    private List<String> createCarList() {
        return Arrays.stream(carNames.split(COMMA))
                .map(String::trim)
                .toList();
    }
}
