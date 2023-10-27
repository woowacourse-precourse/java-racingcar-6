package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(String carsName) {
        this.carList = stringToList(carsName);
    }

    private List<Car> stringToList(String carsName) {
        String[] result = carsName.split(",");

        return Arrays.stream(result)
                .map(Car::new)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
