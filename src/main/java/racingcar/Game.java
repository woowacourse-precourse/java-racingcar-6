package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Car> cars;
    private int[] carWinCount;
    private int gameCount;

    public void setGameCount(int cnt){
        if(cnt > 0){
            gameCount = cnt;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
        carWinCount = new int[cars.size()];
    }
}

