package racingcar.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.Car;

public class MemoryCarRepository implements CarRepository {

    private static Map<Long, Car> store=new HashMap<>();
    private static Long sequence=0L;

    @Override
    public Car save(Car car) {
        store.put(++sequence, car);
        return car;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Car> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Car> findAll() {
        return null;
    }
}
