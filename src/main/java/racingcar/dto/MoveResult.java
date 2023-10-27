package racingcar.dto;

import racingcar.domain.Car;

public record MoveResult(String name, int position) {

    public static MoveResult createResultOf(final Car car) {
        return new MoveResult(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
