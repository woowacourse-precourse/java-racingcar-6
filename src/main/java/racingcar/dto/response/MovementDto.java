package racingcar.dto.response;

import racingcar.domain.Car;

public class MovementDto {
    private static final String RAIL = "-";
    private static final String DELIMITER = " : ";

    private final String movementMessage;

    public MovementDto(final Car car) {
        this.movementMessage = createMessage(car);
    }

    public String createMessage(final Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName())
                .append(DELIMITER)
                .append(RAIL.repeat(car.getForwardCount()));
        return builder.toString();
    }

    public String getMovementMessage() {
        return movementMessage;
    }
}
