package racingcar.domain.car;

import racingcar.controller.dto.CarDto;
import racingcar.controller.dto.WinnerDto;
import racingcar.domain.move.Move;
import racingcar.domain.position.PositionHolder;

public final class Car {

    private final String name;
    private final PositionHolder positionHolder;

    private Car(
            final String name,
            final PositionHolder positionHolder
    ) {
        this.name = name;
        this.positionHolder = positionHolder;
    }

    public static Car from(final String input) {
        return new Car(input, PositionHolder.init());
    }

    public void moveBy(final Move move) {
        positionHolder.increaseBy(move.toInt());
    }

    public int getPosition() {
        return positionHolder.getPosition();
    }

    public CarDto toCarDto() {
        return new CarDto(
                name,
                positionHolder.getPosition()
        );
    }

    public WinnerDto toWinnerDto() {
        return new WinnerDto(name);
    }
}
