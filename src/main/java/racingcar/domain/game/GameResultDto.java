package racingcar.domain.game;

import racingcar.domain.car.CarDto;

import java.util.List;

public record GameResultDto(List<List<CarDto>> logs, List<String> winners) {

}
