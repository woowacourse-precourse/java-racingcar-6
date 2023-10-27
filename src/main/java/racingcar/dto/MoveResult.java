package racingcar.dto;

import racingcar.domain.Car;

public class MoveResult {

    private final String name;
    private final int position;

    private MoveResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

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
