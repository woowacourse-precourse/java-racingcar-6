package racingcar.domain;

import java.util.List;
import racingcar.repository.CarRepository;

public class CarStore {
    private static final CarRepository carRepository = CarRepository.getInstance();
    private static final CarStore instance = new CarStore();

    public static CarStore getInstance() {
        return instance;
    }

    public void saveCarInfo(Car car) {
        carRepository.saveCar(car);
    }

    public Car getCarInfo(int carId) {
        return carRepository.findById(carId);
    }

    public List<Car> findAllCar() {
        return carRepository.findByAll();
    }
}
