package racingcar.domain.car.dto;

import java.util.Objects;

public record CarsNameDto(String names) {

    public CarsNameDto {
        Objects.requireNonNull(names);
    }

}
