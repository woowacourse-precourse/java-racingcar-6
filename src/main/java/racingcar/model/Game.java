package racingcar.model;

import java.util.LinkedHashMap;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class Game {

    private LinkedHashMap<String, Integer> cars;

    public Game(LinkedHashMap<String, Integer> cars) {
        this.cars = cars;
    }

    public String[] splitCarName(String carNames) {
        return carNames.split(",");
    }

    public LinkedHashMap<String, Integer> createCarMap(String[] carNames) {

        cars = new LinkedHashMap<>();

        for (int i = 0; i < carNames.length; i++) {
            cars.putIfAbsent(carNames[i], 0);
        }

        return cars;
    }
}
