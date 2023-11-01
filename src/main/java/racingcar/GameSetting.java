package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {
    private Integer repeatNumber;
    private List<Car> cars = new ArrayList<>();

    public GameSetting(Integer repeatNumber, List<Car> cars) {
        this.repeatNumber = repeatNumber;
        this.cars = cars;
    }

    public Integer getRepeatNumber() {
        return repeatNumber;
    }

    public List<Car> getCars() {
        return cars;
    }
}
