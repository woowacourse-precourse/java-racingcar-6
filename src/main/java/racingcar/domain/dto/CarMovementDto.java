package racingcar.domain.dto;

import racingcar.domain.car.CarName;

public record CarMovementDto(CarName carName, int position) {
}
