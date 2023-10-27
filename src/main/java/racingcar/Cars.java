package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String carsString) {
        List<Car> cars = Arrays.stream(carsString.split(DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .toList();
        this.cars = cars;
    }

    public Car get(int index) {
        return cars.get(index);
    }
}
