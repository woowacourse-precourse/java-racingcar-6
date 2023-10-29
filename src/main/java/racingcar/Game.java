package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Integer> cars = new HashMap<>();
    private int gameCount;

    public void setGameCount(int cnt){
        gameCount = cnt;
    }

    public void setCar(String car){
        cars.put(car, 0);
    }

}
