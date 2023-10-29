package domain;

import util.CarList;

import java.util.List;
import java.util.PriorityQueue;

public class Cars {

    private CarList<Car> cars;
    private PriorityQueue<Car> carMoveCountPQ;

    public Cars(CarList<Car> cars){
        this.cars = cars;
    }

    public CarList<Car> getCars(){
        return cars;
    }

    public void setCarMoveCountPQ(PriorityQueue<Car> carMoveCountPQ){
        this.carMoveCountPQ = carMoveCountPQ;
    }

    public PriorityQueue<Car> getCarMoveCountPQ(){
        return carMoveCountPQ;
    }
}
