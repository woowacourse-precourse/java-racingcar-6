package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.domain.Car;

public interface CarRepository extends Repository<Car> {

    Optional<Car> findByName(String name);
}
