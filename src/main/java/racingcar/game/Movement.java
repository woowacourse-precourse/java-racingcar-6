package racingcar.game;

import racingcar.domain.Car;
import racingcar.util.Generator;

public class Movement {

    private static final int MIN_MOVEMENT_VALUE = 4;

    private final Generator generator;

    public Movement(Generator generator) {
        this.generator = generator;
    }

    public void moveCar(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    private boolean isMovable() {
        return generator.randomNumberGenerate() >= MIN_MOVEMENT_VALUE;
    }
}
