package racingcar.service;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;

import java.util.Optional;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.ExceptionUtil;

public class CarServiceImpl implements CarService {
    private final String DUPLICATE_NAME_MESSAGE = "중복된 이름은 입력할 수 없습니다.";
    private static CarServiceImpl carService;
    private final CarRepository carRepository;

    //DI를 통해 CarRepository가 구현되지 않았을때도 CarService 개발 가능, CarRepository구현체가 바뀌더라도 Service는 영향받지 않음
    private CarServiceImpl(CarRepository carRepository) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carRepository = carRepository;
    }

    public static CarServiceImpl getInstance(CarRepository carRepository) {
        if (carService == null) {
            carService = new CarServiceImpl(carRepository);
        }
        return carService;
    }

    @Override
    public void join(Car car) {
        validateCar(car);
        carRepository.save(car);
    }

    private void validateDuplicatedName(Car car) {
        Optional<Car> result = carRepository.findByName(car.getName());
        result.ifPresent(c -> {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_NAME_MESSAGE);
        });
    }

    private void validateNameLength(Car car) {
        if (car.isNameLengthOver(MAX_CAR_LENGTH.getValue())) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_NAME_MESSAGE);
        }
    }

    private void validateCar(Car car) {
        validateDuplicatedName(car);
        validateNameLength(car);
    }
}
