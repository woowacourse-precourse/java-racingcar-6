package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;
    private  StringBuilder stringBuilder;

    public Cars() {
        this.stringBuilder = new StringBuilder();
    }

    public List<Car> createCars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return carList;
    }

}
