package racingcar.model.dto;

import static racingcar.model.constants.Phrase.MOVEMENT;
import static racingcar.model.constants.Phrase.SEPARATOR;

import racingcar.model.domain.Car;

public class GameResponseDto {
    private final String carName;
    private final int location;

    public GameResponseDto(Car car) {
        carName = car.getName();
        location = car.getLocation();
    }

    public String getCarName() {
        return carName;
    }

    public String getGameResult() {
        return String.join(SEPARATOR.getMessage(), carName, convertTo(location));
    }

    private static String convertTo(int location) {
        return String.valueOf(MOVEMENT.getMessage()).repeat(location);
    }
}
