package racingcar.domain.car;

import racingcar.domain.car.dto.CarsNameDto;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public List<Car> cars;
    public RandomUtil randomUtil;

    public CarGenerator(RandomUtil randomUtil) {
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

    public List<Car> getCars() {
        return cars;
    }
}
