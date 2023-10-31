package racingcar.repository;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {
    private Long id = 0L;
    private final Map<Long, Car>cars = new HashMap<>();

    public Long save(Car car){
        cars.put(id,car);
        id++;
        return id;
    }
}
