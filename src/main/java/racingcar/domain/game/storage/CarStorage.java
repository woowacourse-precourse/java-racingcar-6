package racingcar.domain.game.storage;

import java.util.List;
import racingcar.domain.car.Car;

public interface CarStorage {

	List<Car> saveAll(List<Car> cars);

	List<Car> findAll();
}
