package racingcar.domain.car;

import java.util.List;
import racingcar.dto.Car;
import racingcar.repository.CarRepository;

import static racingcar.exception.InputException.existsNameException;

public class CarInfo {
    private static final CarRepository carRepository = CarRepository.getInstance();
    private static final CarInfo instance = new CarInfo();

    public static CarInfo getInstance() {
        return instance;
    }

    public void saveCarInfo(Car car) {
        if (carRepository.hasName(car.name())) {
            existsNameException();
        }
        carRepository.saveCar(car);
    }

    public void updateCarInfo(Car car) {
        carRepository.saveCar(car);
    }

    public Car getCarInfo(String carName) {
        return carRepository.findByname(carName);
    }

    public List<Car> getAllCarInfo() {
        return carRepository.findByAll();
    }
}
