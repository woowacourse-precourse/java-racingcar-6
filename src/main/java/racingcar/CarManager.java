package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

public class CarManager {
    private Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarManager(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private static final Integer MOVEMENT_CONDITION = 4;

    public void createCars(String[] names) {
        List<Car> carList = Arrays.stream(names).map(Car::new).toList();

        cars = new Cars(carList);
    }

    public void moveCars() {
        cars.getCarList().forEach(car -> {
            Integer randomInteger = randomNumberGenerator.getRandomInteger();

            if (randomInteger >= MOVEMENT_CONDITION) {
                car.incrementDistance();
            }
        });
    }

    public Cars getWinners() {
        List<Car> carsWithHighestDistance = cars.getCarsWithHighestDistance();
        return new Cars(carsWithHighestDistance);
    }

    public Cars getCars() {
        return cars;
    }
}
