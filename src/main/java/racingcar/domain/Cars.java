package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
