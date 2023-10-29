package racingcar.domain.service;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.repository.CarRepository;
import racingcar.exception.CarRepositoryException;
import racingcar.exception.validtaion.CarValidationHandler;
import racingcar.utils.RacingCarStringUtils;

public class CarService {

    private final CarRepository carRepository;
    private static final int FORWARD_THRESHOLD = 4;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car move(String carName, int number) {
        Car findCar = carRepository.findByCarName(carName)
                .orElseThrow(() -> new CarRepositoryException(CarRepositoryException.NOT_FOUND));

        if (isForward(number)) {
            int distance = findCar.getDistance();
            findCar.changeDistance(distance + 1);

            carRepository.update(findCar);
            return findCar;
        }

        return findCar;
    }

    private boolean isForward(int number) {
        return number >= FORWARD_THRESHOLD;
    }

    public void saveCarName(String carNames) {
        List<String> carNameList = RacingCarStringUtils.parseCarNamesToList(carNames);
        carNameList.forEach(carName -> {
            validationCarName(carName);
            carRepository.save(Car.create(carName));
        });
    }

    private void validationCarName(String carName) {
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
        CarValidationHandler.validationCarNameUnder5Length(carName);
    }
}
