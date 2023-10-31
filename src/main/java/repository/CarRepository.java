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
    private Map<Car,Integer> carMap = new HashMap<>();
    private static CarRepository carRepository = new CarRepository();
    private CarRepository(){}
    public static CarRepository getInstance(){
        return carRepository;
    }

    public void save(Car car){
        if(!carMap.containsKey(car))
            carMap.put(car,0);
    }
    public void moveForward(Car car, Move move){
        if(move == Move.STOP)
            return;
        if(carMap.containsKey(car))
            carMap.put(car,carMap.get(car) + 1);
    }
    public List<Car> findAllCars(){
        return new ArrayList<>(carMap.keySet());
    }

}
