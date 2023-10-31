package racingcar.domain.factory;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import racingcar.domain.Car;

public class CarFactory {
    public static final int DEFAULT_CAR_POSITION = 0;

    private final BooleanSupplier intSupplier;
    private final Consumer<String> validator;

    public CarFactory(BooleanSupplier intSupplier, Consumer<String> validator) {
        this.intSupplier = intSupplier;
        this.validator = validator;
    }

    public Car create(String name, int position, BooleanSupplier intSupplier) {
        validator.accept(name);
        return new Car(name, position, intSupplier);
    }

    public Car create(String name, int position) {
        return create(name, position, intSupplier);
    }

    public Car create(String name) {
        return create(name, DEFAULT_CAR_POSITION, intSupplier);
    }
}
