package racingcar.domain.car;

import java.util.List;
import racingcar.dto.Car;
import racingcar.repository.CarRepository;

public class CarInfo {
    private static final CarRepository carRepository = CarRepository.getInstance();
    private static final CarInfo instance = new CarInfo();

    public static CarInfo getInstance() {
        return instance;
    }

    public void saveCarInfo(Car car) {
        carRepository.saveCar(car);
    }

    public Car getCarInfo(String carName) {
        return carRepository.findByname(carName);
    }

    public List<Car> getAllCarInfo() {
        return carRepository.findByAll();
    }
}
