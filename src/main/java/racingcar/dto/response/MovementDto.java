package racingcar.dto.response;

import racingcar.domain.Car;

public class MovementDto {
    private static final String RAIL = "-";
    private static final String DELIMITER = " : ";

    private final String carName;
    private final Integer forwardCount;

    public MovementDto(final Car car) {
        this.carName = car.getName();
        this.forwardCount = car.getForwardCount();
    }

    public String createMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(carName)
                .append(DELIMITER)
                .append(RAIL.repeat(forwardCount));
        return builder.toString();
    }
}
