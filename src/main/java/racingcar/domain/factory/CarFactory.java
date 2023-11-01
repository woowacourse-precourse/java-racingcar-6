package racingcar.domain.factory;

import java.util.function.BooleanSupplier;
import racingcar.domain.Car;

public class CarFactory {
    private static final int DEFAULT_CAR_POSITION = 0;

    private final BooleanSupplier engine;

    public CarFactory(BooleanSupplier intSupplier) {
        this.engine = intSupplier;
    }

    public Car create(String name) {
        return new Car(name, DEFAULT_CAR_POSITION, engine);
    }
}
