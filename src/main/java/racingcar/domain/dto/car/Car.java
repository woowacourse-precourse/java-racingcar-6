package racingcar.domain.dto.car;

import racingcar.domain.dto.position.PositionHolder;

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
}
