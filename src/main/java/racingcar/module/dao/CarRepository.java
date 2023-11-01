package racingcar.module.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.module.domain.Car;

public class CarRepository {

    private Long id = 0L;
    private final Map<Long, Car> store = new HashMap<>();
    private static final CarRepository instance = new CarRepository();

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        return instance;
    }

    public Car save(Car car) {
        car.setId(++id);
        store.put(car.getId(), car);
        return car;
    }

    public List<Car> findByGame(Long gameId) {
        List<Car> carList = new ArrayList<>();
        store.values().stream().filter(car -> car.getGameId().equals(gameId))
                .forEach(car -> carList.add(car));
        return carList;
    }
}
