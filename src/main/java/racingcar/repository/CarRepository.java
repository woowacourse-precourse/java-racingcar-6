package racingcar.repository;

import java.util.List;
import racingcar.database.CarData;
import racingcar.domain.Car;

public class CarRepository {

    CarData carData = new CarData();

    public void saveAll(List<Car> carList) {
        carData.addAll(carList);
    }
}
