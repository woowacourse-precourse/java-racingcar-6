package racingcar.repository;

import java.util.Optional;
import racingcar.domain.Car;

public interface CarRepository extends Repository {

    Optional<Car> findByName(String name);
}
