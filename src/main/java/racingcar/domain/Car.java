package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {

    private final Map<String, Integer> result;

    public Car(String names) {
        Maker maker = new Maker(names);
        result = maker.makeMap();
    }

    public void start() {
        for (String name : result.keySet()) {
            counter(name);
        }
    }

    public String getWinner() {
        return GetWinner.winner(result);
    }

    private void counter(String name) {
        if (RandomNumberMaker.getRandomNumber() >= 4) {
            result.put(name, result.get(name) + 1);
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
