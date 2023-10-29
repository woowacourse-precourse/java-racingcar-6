package racingcar.repository;

import racingcar.model.Car;

import java.util.*;

public class MemoryCarRepository implements CarRepository {
    private static Map<Long, Car> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Car save(Car car) {
        car.setId(++sequence);
        store.put(car.getId(), car);
        return car;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Car> findByName(String name) {
        return store.values().stream() // 루프를 돌면서
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 찾으면
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
