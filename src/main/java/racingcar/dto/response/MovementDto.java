package racingcar.dto.response;

import static racingcar.constants.Format.MOVEMENT_DELIMITER;
import static racingcar.constants.Format.RAIL;

import racingcar.domain.Car;

public class MovementDto {

    private final String carName;
    private final Integer forwardCount;

    public MovementDto(final Car car) {
        this.carName = car.getName();
        this.forwardCount = car.getForwardCount();
    }

    public String createMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(carName)
                .append(MOVEMENT_DELIMITER)
                .append(RAIL.repeat(forwardCount));
        return builder.toString();
    }
}
