package racingcar.dto;

import racingcar.domain.Car;

public record MoveResult(String name, int position) {

    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String MOVEMENT_BAR = "-";

    public static MoveResult createResultFrom(final Car car) {
        return new MoveResult(car.getName(), car.getPosition());
    }

    @Override
    public String toString() {
        return String.format(RESULT_FORMAT, name, MOVEMENT_BAR.repeat(position));
    }
}
