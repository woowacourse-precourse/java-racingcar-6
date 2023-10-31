package racingcar.model;

import java.util.List;

public class Game {
    private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars(){
        return cars;
    }
}
