package racingcar;

import java.util.List;
import java.util.Map;

public class SnapShot {
    private int tryCount;
    private List<Car> cars;
    private List<Map<Car, Integer>> snapShot;

    void setCars(List cars){
        this.cars = cars;
    }
}
