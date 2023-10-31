package model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> carList;

    public CarList(){
        carList = new ArrayList<>();
    }
    public void addCar(final String carName){
        Car tmpCar = new Car(carName);
        carList.add(tmpCar);
    }
    public List<Car> getCarList(){
        return this.carList;
    }

}
