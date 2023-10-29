package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import racingcar.domain.Car;

public class MemoryCarRepository implements CarRepository {

    private static final MemoryCarRepository memoryCarRepository = new MemoryCarRepository();
    private static Map<Long, Car> store = new HashMap<>();
    private static Long sequence;

    private MemoryCarRepository() {
        resetSequence();
    }

    private void resetSequence() {
        sequence = 0L;
    }

    public static MemoryCarRepository getInstance() {
        return memoryCarRepository;
    }

    @Override
    public Car save(Car car) {
        store.put(++sequence, car);
        car.setId(sequence);
        return car;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Car> findByName(String name) {
        return store.values().stream()
                .filter(car -> car.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteAll() {
        store.clear();
        resetSequence();
    }
}
