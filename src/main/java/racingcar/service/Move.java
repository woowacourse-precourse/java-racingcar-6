package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Move {
    Car car = new Car();

    public void moveTheCar(LinkedHashMap<String, String> carList, List<Integer> randomNumberList) {
        int randomNumberListIndex = 0;
        for (Map.Entry<String, String> entry : carList.entrySet()) {
            String key = entry.getKey();
            if (randomNumberList.get(randomNumberListIndex) >= 4) {
                String moveValue = carList.get(key);
                carList.put(key, moveValue + "-");
            }
            randomNumberListIndex++;
        }
    }

    public void stopTheCar(LinkedHashMap<String, String> carList, List<Integer> randomNumberList) {
        String moveValue = car.getCarList().get(carname);
        car.getCarList().put(carname, moveValue + "");
    }
}
