package racingcar;

import java.util.HashMap;
import java.util.List;

public class CarRacing {
    private HashMap<String, Integer> racingMap;

    CarRacing(List<String> carList) {
        this.racingMap = new HashMap<String, Integer>();

        for (String car : carList) {
            this.racingMap.put(car, 0);
        }
    }
    
}
