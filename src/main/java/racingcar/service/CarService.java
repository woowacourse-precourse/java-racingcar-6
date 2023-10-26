package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {

    private List<Car> carList = new ArrayList<>();

    public void init(String[] carNamesArr) {
        this.carList = mapToCarList(carNamesArr);
    }

    private List<Car> mapToCarList(String[] carNamesArr) {
        return Arrays.stream(carNamesArr).map(n -> new Car(n)).toList();
    }
}
