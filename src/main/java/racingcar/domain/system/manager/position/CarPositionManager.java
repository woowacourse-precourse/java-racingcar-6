package racingcar.domain.system.manager.position;

import java.util.List;
import java.util.Map;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.SavedCar;

public interface CarPositionManager {

    SavedCarPosition save(SavedCar car, Long position);

    List<SavedCarPosition> saveAll(Map<SavedCar, Long> carPositions);

    SavedCarPosition findByCar(SavedCar car);

    Map<CarName, SavedCarPosition> findAll(List<SavedCar> cars);
}
