package racingcar.domain.car;

import static racingcar.exception.InputException.existsNameException;

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

    public void allSaveCarInfo(List<String> carList) {
        IntStream.range(0, carList.size())
                .mapToObj(id -> new Car(carList.get(id), 0))
                .forEach(this::saveCarInfo);
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
