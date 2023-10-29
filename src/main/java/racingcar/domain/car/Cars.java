package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import racingcar.mapper.CarMapper;
import racingcar.utils.CarValidator;

public class Cars {
    private List<Car> cars;

    public Cars(String names) {
        List<Car> targetCars = CarMapper.convertToCarList(names);
        CarValidator.validateCars(targetCars);
        this.cars = targetCars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Car findCarByIndex(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }
}
