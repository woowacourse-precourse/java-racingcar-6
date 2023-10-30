package racingcar.domain.system.manager.car;

import java.util.List;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;

public interface CarManager {

    SavedCar save(Car car);

    List<SavedCar> saveAll(List<Car> cars);

    SavedCar findByName(CarName carName);

    List<SavedCar> findAll();

    List<SavedCar> findAll(List<CarKey> keys);
}
