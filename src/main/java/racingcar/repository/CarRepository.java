package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Car;

public class CarRepository {
    private long id = 0L;
    private final Map<Long, Car> cars = new HashMap<>();
    //자동차 이름 저장
    public long save(Car car) {
        cars.put(id, car);
        id += 1;
        return id;
    }
    //자동차들의 이름을 배열로 호출
    public List<Car> all_Cars() {
        return new ArrayList<>(cars.values());
    }
}