package racingcar.dto;

import racingcar.domain.car.RaceCars;

public record RaceGameInfoDto(RaceCars raceCars, int attemptCount) {

}
