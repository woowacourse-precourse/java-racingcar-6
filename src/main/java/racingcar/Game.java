package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Car> cars;
    private int gameCount;

    public void setGameCount(int cnt){
        gameCount = cnt;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

