package racingcar.domain.car;

import static racingcar.constant.GameConstant.INITIAL_CAR_INDEX;
import static racingcar.exception.InputException.existsNameException;
import static racingcar.exception.InputException.notExistsNameException;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.Car;
import racingcar.repository.CarRepository;

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

    public void saveAllCarInfo(List<String> carList) {
        IntStream.range(0, carList.size())
                .mapToObj(id -> new Car(carList.get(id), INITIAL_CAR_INDEX))
                .forEach(this::saveCarInfo);
    }

    public void updateCarInfo(Car car) {
        if (!carRepository.hasName(car.name())) {
            notExistsNameException();
        }
        carRepository.saveCar(car);
    }

    public Car getCarInfo(String carName) {
        return carRepository.findByName(carName);
    }

    public List<Car> getAllCarInfo() {
        return carRepository.findByAll();
    }
}
