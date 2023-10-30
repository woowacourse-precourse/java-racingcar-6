package racingcar.domain.system.manager.car;

import java.util.List;
import racingcar.domain.core.car.BasicCar;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.key.CarKey;
import racingcar.domain.system.manager.car.value.SavedCar;

public interface CarManager {

    SavedCar save(BasicCar car);

    List<SavedCar> saveAll(List<? extends BasicCar> cars);

    SavedCar findByName(CarName carName);

    List<SavedCar> findAll();

    List<SavedCar> findAll(List<CarKey> keys);
}
