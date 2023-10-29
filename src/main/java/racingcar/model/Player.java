package racingcar.model;

import java.util.List;

public class Player {

    private final List<Car> cars;
    private final int times;

    public Player(List<Car> cars, int times){
        this.cars = cars;
        this.times = times;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }
}
