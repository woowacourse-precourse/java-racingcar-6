package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {

    private Map<String, Integer> car = new HashMap<>();

    public void initCar(List<String> carlist) {
        for (String element : carlist) {
            this.car.put(element,0);
        }
    }

    public Map<String, Integer> getGameDate() {
        return this.car;
    }

    public void clear() {
        car.clear();
    }

}
