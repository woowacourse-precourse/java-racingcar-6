package racingcar.repository;

import java.util.Optional;
import racingcar.domain.Car;

public class MemoryCarRepository extends MemoryRepository<Car> implements CarRepository {

    @Override
    public Optional<Car> findByName(String name) {
        return store.values().stream()
                .filter(car -> car.getName().equals(name))
                .findFirst();
    }
}
