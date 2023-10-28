package model;

import java.util.ArrayList;
import java.util.List;
public class GroupOfCar {
    private final List<Car> groupOfCar = new ArrayList<Car>();

    public void addCar(Car car){
        this.groupOfCar.add(car);
    }

}
