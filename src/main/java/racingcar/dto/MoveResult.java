package racingcar.dto;

import racingcar.domain.Car;

public record MoveResult(String name, int position) {

    public static MoveResult createResultFrom(final Car car) {
        return new MoveResult(car.getName(), car.getPosition());
    }
}
