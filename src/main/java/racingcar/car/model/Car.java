package racingcar.car.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Car {

    private HashMap<String,Integer> cars;
    public Car(){
        cars = new HashMap<>();
    }
    public Car(String name, int moveCount){
        cars.put(name,moveCount);
    }
}
