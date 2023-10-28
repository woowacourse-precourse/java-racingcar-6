package racingcar.dto;

import java.util.List;

import racingcar.domain.Car;

public record GameDto(List<Car> cars, Long roundCount) {
}
