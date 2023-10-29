package racingcar.model.dto;

import static racingcar.model.constants.Rule.MOVEMENT;

import racingcar.model.domain.Car;

public class GameResponseDto {
    private final String carName;
    private final int location;

    public GameResponseDto(Car car) {
        this.carName = car.getName();
        this.location = car.getLocation();

    }

    public String createMessage() {
        return carName + " : " + createScore(location);
    }

    private static String createScore(int location) {
        if (location == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append(MOVEMENT.getMessage());
        }
        return stringBuilder.toString();
    }

    public String getCarName() {
        return carName;
    }
}
