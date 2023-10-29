package racingcar.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.Domain.Car;

public class CarRepository {
    private Long id = 0L;
    private final Map<Long, Car> carList = new HashMap<>();

    public Long saveCarName(Car car) {
        Long generatedId = generateUniqueId();
        carList.put(generatedId, car);
        return generatedId;
    }

    public List<Car> findAll() {
        return new ArrayList<>(carList.values());
    }

    private Long generateUniqueId() {
        return ++id;
    }
}
