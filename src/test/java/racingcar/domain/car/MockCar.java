package racingcar.domain.car;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;

public class MockCar extends Car {

    private static final CarName SUPER_CAR_NAME = CarName.from("mock");
    private static final CarPosition SUPER_POSITION = CarPosition.create();
    private static final BooleanSupplier ALWAYS_MOVE_STRATEGY = () -> true;

    private final String name;
    private int position;
    private final BooleanSupplier movingStrategy;

    public MockCar(String name, int position, BooleanSupplier movingStrategy) {
        super(SUPER_CAR_NAME, SUPER_POSITION, ALWAYS_MOVE_STRATEGY);
        this.name = name;
        this.position = position;
        this.movingStrategy = Objects.requireNonNull(movingStrategy);
    }

    @Override
    public void move() {
        if (movingStrategy.getAsBoolean()) {
            position++;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
