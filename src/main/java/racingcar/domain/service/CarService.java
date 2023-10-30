package racingcar.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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

    public List<Car> registerCarsByCarNames(String carNames) {
        List<String> carNameList = RacingCarStringUtils.parseCarNamesToList(carNames);
        Set<String> carNameSet = RacingCarStringUtils.parseCarNamesToSet(carNames);
        validationCarNames(carNameList, carNameSet);

        List<Car> cars = new ArrayList<>();
        carNameList.forEach(carName -> {
            validationCarName(carName);
            Car car = Car.create(carName);
            cars.add(car);
            carRepository.save(car);
        });

        return Collections.unmodifiableList(cars);
    }

    private void validationCarName(String carName) {
        CarValidationHandler.validationHasText(carName);
        CarValidationHandler.validationAlphaNumericOrAlphaOrNumeric(carName);
        CarValidationHandler.validationCarNameUnder5Length(carName);
    }

    private void validationCarNames(List<String> carNameList, Set<String> carNameSet) {
        CarValidationHandler.validationDuplicatedCarNames(carNameList, carNameSet);
        CarValidationHandler.validationCarNamesOneSize(carNameList);
    }
}
