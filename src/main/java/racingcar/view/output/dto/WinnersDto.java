package racingcar.view.output.dto;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Winners;

public record WinnersDto(
    List<Car> winners
) {

    public static WinnersDto from(Winners winners) {
        return new WinnersDto(winners.cars());
    }
}
