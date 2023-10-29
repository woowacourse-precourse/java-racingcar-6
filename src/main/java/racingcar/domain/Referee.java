package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    protected Referee() {

    }

    public static List<String> calculateCars(CarGenerator cars) {
        int maxNum = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cars.getNames().length; i++) {
            maxNum = Math.max(maxNum, cars.getLocations()[i].length());
        }
        for (int i = 0; i < cars.getNames().length; i++) {
            if (maxNum == cars.getLocations()[i].length()) {
                result.add(cars.getNames()[i]);
            }
        }
        return result;
    }
}
