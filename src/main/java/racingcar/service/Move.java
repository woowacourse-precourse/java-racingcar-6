package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;
import java.util.LinkedHashMap;
import java.util.List;

public class Move {
    Car car = new Car();

    public void moveTheCar(LinkedHashMap<String, String> carList, List<Integer> randomNumberList) {
        int randomNumberListIndex = 0;
        carList.forEach((key, value) -> {
            if (randomNumberList.get(randomNumberListIndex) >= 4) {
                String moveValue = car.getCarList().get(key);
                car.getCarList().put(key, moveValue + "-");
            }
        });
    }

    public void stopTheCar(String carname) {
        String moveValue = car.getCarList().get(carname);
        car.getCarList().put(carname, moveValue + "");
    }
}
