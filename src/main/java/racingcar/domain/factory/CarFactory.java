package racingcar.domain.factory;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import racingcar.domain.Car;

public class CarFactory {
    private static final int DEFAULT_CAR_POSITION = 0;

    private final BooleanSupplier engine;
    private final Consumer<String> validator;

    public CarFactory(BooleanSupplier intSupplier, Consumer<String> validator) {
        this.engine = intSupplier;
        this.validator = validator;
    }

    public Car create(String name) {
        validator.accept(name);
        return new Car(name, DEFAULT_CAR_POSITION, engine);
    }
}
