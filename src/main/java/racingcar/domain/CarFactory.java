package racingcar.domain;

import java.util.function.Consumer;
import java.util.function.IntSupplier;

public class CarFactory {
    public static final int DEFAULT_CAR_POSITION = 0;

    private final IntSupplier intSupplier;
    private final Consumer<String> validator;

    public CarFactory(IntSupplier intSupplier, Consumer<String> validator) {
        this.intSupplier = intSupplier;
        this.validator = validator;
    }

    public Car create(String name, int position, IntSupplier intSupplier) {
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
