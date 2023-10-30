package racingcar.model.dto;

import static racingcar.model.constants.Rule.MOVEMENT;
import static racingcar.model.constants.Rule.SEPARATOR;
import static racingcar.model.constants.Rule.STOP;

import racingcar.model.domain.Car;

public class GameResponseDto {
    private final String carName;
    private final int location;

    public GameResponseDto(Car car) {
        carName = car.getName();
        location = car.getLocation();
    }

    public String getGameResult() {
        return String.join(SEPARATOR.getMessage(), carName, convertTo(location));
    }

    private static String convertTo(int location) {
        return String.valueOf(MOVEMENT.getMessage()).repeat(Math.max(STOP.getValue(), location));
    }

    public String getCarName() {
        return carName;
    }
}
