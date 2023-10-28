package racingcar.domain.car;

import racingcar.domain.car.dto.CarsNameDto;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> cars;
    public RandomUtil randomUtil;

    public Cars(RandomUtil randomUtil) {
        this.cars = new ArrayList<>();
        this.randomUtil = randomUtil;
    }

    public void generateCars(CarsNameDto names) {
        String carNames = names.names();
        String[] carNamesArr = carNames.split(",");
        for (String carName : carNamesArr) {
            Car car = new Car(carName, randomUtil);
            cars.add(car);
        }
    }
    public void runRace() {
        cars.forEach(Car::moveCar);
    }

    public String generateExecutionResultAllCars() {
        Car firstCar = cars.get(0);
        String firstResult = firstCar.generateExecutionResult();

        StringBuilder results = new StringBuilder(firstResult);
        for (int i = 1; i<cars.size(); i++) {
            results.append('\n');
            Car car = cars.get(i);
            String result = car.generateExecutionResult();
            results.append(result);
        }
        return results.toString();
    }

    public List<Car> getCars() {
        return cars;
    }
}
