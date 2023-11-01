package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceService {
    public void CarList(String carNames) {
        List<Car> carList = new ArrayList<>();

        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }
}
