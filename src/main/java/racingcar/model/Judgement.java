package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    public int findMaxLocation(List<Car> carList) {
        int maxValue = 0;
        for (Car car : carList) {
            int carLocation = car.getLocation();
            if (carLocation > maxValue) {
                maxValue = carLocation;
            }
        }
        return maxValue;
    }
}
