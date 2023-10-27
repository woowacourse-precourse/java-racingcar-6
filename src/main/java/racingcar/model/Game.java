package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> carList ;

    public Game(){
        carList = new ArrayList<>();
    }

    public void addCar(Car car){
        carList.add(car);
    }

    public List<Car> getCar(){
        return carList;
    }
}
