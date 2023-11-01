package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CarRepository {

    private Long nextCarId = 0L;
    private final Map<Long, Car> carMap = new HashMap<>();

    // 자동차 저장
    public Long save(Car car) {
        carMap.put(nextCarId, car);
        nextCarId++;
        return nextCarId;
    }


    // 모든 자동차 목록 반환
    public List<Car> findAllCars() {
        return new ArrayList<>(carMap.values());
    }

}
