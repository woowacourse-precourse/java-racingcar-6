package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Cars {
    private List<String> cars;

    public Cars(List<String> cars) {
        this.cars = cars;
    }

    public LinkedHashMap<String, String> initGameResult() {
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        for (String car : cars) {
            gameResult.put(car, "");
        }
        return gameResult;
    }

}
