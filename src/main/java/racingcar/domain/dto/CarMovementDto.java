package racingcar.domain.dto;

import racingcar.domain.game.car.CarName;

public record CarMovementDto(CarName carName, int position) {
}
