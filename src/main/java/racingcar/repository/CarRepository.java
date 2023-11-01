package racingcar.repository;

import java.util.List;
import racingcar.database.CarData;
import racingcar.domain.Car;

public class CarRepository {

    CarData carData = new CarData();

    public void saveAll(List<Car> carList) {
        carData.addAll(carList);
    }

    public int countByProgressDescLimitOne() {
        return carData.getCountMax();
    }

    public List<Car> findAllByProgress(int maxProgress) {
        return carData.findAllByProgress(maxProgress);
    }

    public List<Car> findAll() {
        return carData.findAll();
    }

    public List<Car> updateAll(List<Car> findCars) {
        return carData.updateAll(findCars);
    }
}
