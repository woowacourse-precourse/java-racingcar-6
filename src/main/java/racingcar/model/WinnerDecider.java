package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerDecider {
    public String winner;

    public String getWinner() {
        return winner;
    }

    public List<String> collectNamesOfTopCars(List<Car> carList) {
        int maxDistance = 0;
        List<String> topCarNames = new ArrayList<>();

        for (Car car : carList) {
            int distance = car.getDistance();

            if (distance > maxDistance) {
                maxDistance = distance;
                topCarNames.clear();
                topCarNames.add(car.getName());
            } else if (distance == maxDistance) {
                topCarNames.add(car.getName());
            }
        }

        return topCarNames;
    }
}
