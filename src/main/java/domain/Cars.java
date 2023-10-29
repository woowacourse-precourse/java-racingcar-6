package domain;

import util.CarList;

import java.util.List;

public class Cars {

    private CarList<Car> cars;

    //TODO list contains 오버라이딩
    public Cars(CarList<Car> cars){
        this.cars = cars;
    }
}
