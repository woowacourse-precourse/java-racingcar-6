package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.mapper.CarMapper;

public class Cars {
    private List<Car> cars;

    public Cars(String cars) {
        List<Car> targetCars = CarMapper.stringToCarList(cars);
        this.cars = targetCars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
