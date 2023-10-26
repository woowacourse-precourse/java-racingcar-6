package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;


    private Cars(List<Car> carList){
        this.carList = carList;
    }

    public static Cars makeCarList(List<String> carNames){
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move() {
        carList.forEach(Car::move);
    }
}
