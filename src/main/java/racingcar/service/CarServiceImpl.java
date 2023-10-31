package racingcar.service;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;

import java.util.Optional;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.ExceptionUtil;

public class CarServiceImpl implements CarService {
    private final String NAME_LENGTH_OVER_MESSAGE = "이름의 길이가 초과되었습니다.";
    private final String ALPHA_NUMERIC_NAME_MESSAGE = "이름은 알파벳, 숫자만 가능합니다.";
    private final CarRepository carRepository;

    //DI를 통해 CarRepository가 구현되지 않았을때도 CarService 개발 가능, CarRepository구현체가 바뀌더라도 Service는 영향받지 않음
    public CarServiceImpl(CarRepository carRepository) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carRepository = carRepository;
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
            ExceptionUtil.throwInvalidValueException(NAME_LENGTH_OVER_MESSAGE);
        }
    }

    private void validateAlphaNumeric(Car car) {
        if (!car.matchNamePattern("^[a-zA-Z0-9]*$")) {
            ExceptionUtil.throwInvalidValueException(ALPHA_NUMERIC_NAME_MESSAGE);
        }
    }

    private void validateCar(Car car) {
        validateDuplicatedName(car);
        validateNameLength(car);
        validateAlphaNumeric(car);
    }
}
