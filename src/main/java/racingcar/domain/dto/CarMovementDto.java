package racingcar.domain.dto;

import racingcar.domain.game.CarName;

public record CarMovementDto(CarName carName, int position) {
}
