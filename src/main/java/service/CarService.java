package service;

import domain.Car;
import domain.Move;
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
    public int repositorySize(){
        return carRepository.size();
    }
    public void moveAllCars(List<Integer> moveConditionValues){
        int listSize = repositorySize();
        for(int i=0; i< listSize; i++){
            int moveCondition = moveConditionValues.get(i);

            Move move = Move.STOP;
            if(moveCondition >= 4)
                move = Move.FORWARD;

            carRepository.moveForward(i,move);
        }
    }


}
