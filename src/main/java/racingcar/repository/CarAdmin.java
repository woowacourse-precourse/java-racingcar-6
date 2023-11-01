package racingcar.repository;

import racingcar.domain.Car;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarAdmin {
    private final Map<Integer, Car> cars = new HashMap<>();
    private int ID = 0;

    public void createCar(Car car){
        cars.put(ID, car);
        ID += 1;
    }
    public List<Car> getCars(){
        return new ArrayList<>(cars.values());
    }
}