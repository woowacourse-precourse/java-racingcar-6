package racingcar.domain.car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String cars) {
        List<Car> targetCars = convertStringToCar(cars);
        this.cars = targetCars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> convertStringToCar(String cars) {
        String[] tokens = cars.split(DELIMITER);
        return Arrays.stream(tokens)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
