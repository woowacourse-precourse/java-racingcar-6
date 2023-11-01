package racingcar.controller.dto.response;

import java.util.List;
import racingcar.model.Car;

public record RaceResultDto(List<Car> carList) {
}
