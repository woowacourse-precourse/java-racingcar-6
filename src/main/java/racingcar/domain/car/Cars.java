package racingcar.domain.car;

import java.util.List;

public abstract class Cars {
    protected final List<? extends Car> cars;

    protected Cars(final List<? extends Car> cars) {
        this.cars = cars;
    }

}
