package racingcar.domain.dto.input;

import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

public record CarsDto(String carNames) {
    private static final String COMMA = ",";

    public Cars toCars() {
        return Cars.from(splitNamesToList());
    }

    private List<String> splitNamesToList() {
        return Arrays.stream(carNames.split(COMMA))
                .toList();
    }
}
