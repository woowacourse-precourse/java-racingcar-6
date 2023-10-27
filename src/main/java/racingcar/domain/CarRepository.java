package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private static final CarRepository instance = new CarRepository();

    private final List<Car> carStore = new ArrayList<>();

    public static CarRepository getInstance() {
        return instance;
    }

    public void saveAll(final List<Car> cars) {
        carStore.addAll(cars);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(carStore);
    }
}
