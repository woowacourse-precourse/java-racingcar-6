package racingcar.domain.dto;

import racingcar.domain.Cars;

import java.util.Arrays;

public record CarsDto(String carNames) {

    public Cars toCars() {
        return Cars.from(Arrays.stream(carNames.split(",")).toList());
    }
}
