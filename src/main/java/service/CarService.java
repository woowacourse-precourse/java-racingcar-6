package service;

import domain.Car;
import repository.CarRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarService {
    CarRepository carRepository;
    public CarService(){
        carRepository = CarRepository.getInstance();
    }
    public List<Car> findCars(){
        return carRepository.findAllCars();
    }
    public void saveCars(String[] carNames){
        for(String s : carNames){
            Car car = new Car(s);
            carRepository.save(car);
        }
    }

}
