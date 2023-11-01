package domain;

import util.CarList;

import java.util.List;
import java.util.PriorityQueue;

public class Cars {

    private CarList<Car> cars;

    public Cars(CarList<Car> cars){
        this.cars = cars;
    }

    public CarList<Car> getCars(){
        return cars;
    }

}
