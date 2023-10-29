package racingcar.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Game(Integer playCount) {
        this.playCount = playCount;
    }

    private List<Car> carList = new ArrayList<>();

    private Integer playCount;

    public void addCar(Car car) {
        carList.add(car);
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }
}
