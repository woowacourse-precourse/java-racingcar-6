package repository;

import domain.Car;
import domain.Move;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRepository {
    private List<Car> carList = new ArrayList<>();
    private static CarRepository carRepository = new CarRepository();
    private CarRepository(){}
    public static CarRepository getInstance(){
        return carRepository;
    }

    public void save(Car car){
        if(!carList.contains(car))
            carList.add(car);
    }
    public void moveForward(Car car, Move move){
        if(move == Move.STOP)
            return;
        if(carList.contains(car))
            car.moveForward();
    }
    public List<Car> findAllCars(){
        return carList;
    }

}
