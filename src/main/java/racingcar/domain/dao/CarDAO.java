package racingcar.domain.dao;

import racingcar.domain.db.CarsData;
import racingcar.domain.entity.CarEntity;
import racingcar.dto.CarResponse;

import java.util.List;

public class CarDAO {
    public static void saveAll(CarResponse carName) {
        CarsData.addCar(new CarEntity(carName.getCarName(), carName.getPosition()));
    }

    public static List<CarEntity> loadAll() {
        return CarsData.getCars();
    }
}
