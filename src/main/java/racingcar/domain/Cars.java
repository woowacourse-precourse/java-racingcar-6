package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.dto.CarsGenerateDto;
import racingcar.exception.CarListEmptyException;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.BasicMovementRule;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(BasicMovementRule basicMovementRule, RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(basicMovementRule, randomNumber);
        }
    }

    public static Cars generate(CarsGenerateDto carsGenerateDto) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carsGenerateDto.carsName()) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    public Car findMaxCarPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(CarListEmptyException::new);
    }

    public List<Car> getCarsList() {
        return Collections.unmodifiableList(cars);
    }
}
