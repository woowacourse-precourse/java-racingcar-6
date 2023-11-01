package racingcar.service;

import static racingcar.domain.Car.createCarByCarName;

import java.util.ArrayList;
import java.util.List;
import racingcar.resolver.InputResolver;
import racingcar.domain.Car;

public class CarService {
    public List<Car> createCarList(List<String> carNameList) {
        return registerCarList(carNameList);
    }

    private List<Car> registerCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(createCarByCarName(carName));
        }
        return carList;
    }



}
