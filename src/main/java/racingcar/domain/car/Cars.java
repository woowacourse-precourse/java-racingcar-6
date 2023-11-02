package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String SEPARATOR = ",";

    private List<Car> cars;
    private RandomUtil randomUtil;

    public Cars(RandomUtil randomUtil, String carNames) {
        this.randomUtil = randomUtil;
        this.cars = new ArrayList<>();
        generateCars(carNames);
    }

    public void generateCars(String carNames) {
        String[] carNamesArr = carNames.split(SEPARATOR);
        for (String carName : carNamesArr) {
            Car car = new Car(carName, randomUtil);
            cars.add(car);
        }
    }
    public void runRace() {
        cars.forEach(Car::moveCar);
    }

    public List<Car> getCars() {
        return cars;
    }
}
