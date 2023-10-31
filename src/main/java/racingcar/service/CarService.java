package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.carRepository.CarRepositoryInterface;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final CarRepositoryInterface carRepository;

    public CarService(CarRepositoryInterface carRepository) {
        this.carRepository = carRepository;
    }

    private  Car car;

    public void createCar(String[] cars){
        for(String carName : cars){
            car = Car.createCar(carName);
            carRepository.saveCar(car);
        }
    }

    public void movieCar(){
        List<Car> cars = getCars();
        for(int index=0; index<cars.size(); index++){
            Car car = cars.get(index);
            int randomNumber= getRandomNumber();
            Car movingCar = movingCar(randomNumber,car);
            carRepository.updateCar(movingCar,index);
        }
    }

    public List<Car> getCars(){
        List<Car> cars = carRepository.getCars();
        return cars;
    }

    public List<Car> finalResult(){
        List<Car> cars = carRepository.getCars();
        List<Car> maxDistanceCars = maxDistanceCar(cars);
        return  maxDistanceCars;
    }



    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    private  Car movingCar(int randomNumber,Car car){
        if(randomNumber>=4){
            car.setDistance(car.getDistance()+1);
        }
        return car;

    }
    private List<Car> maxDistanceCar(List<Car> cars){
        List maxDistanceCars = new ArrayList();
        Car maxCar = cars.get(0);
        for(Car car : cars){
             if(car.getDistance() > maxCar.getDistance()){
                 maxCar = car;
             }
        }
        for(Car car : cars){

            if(maxCar.getDistance() == car.getDistance()){
                maxDistanceCars.add(car);
            }

        }
        return maxDistanceCars;
    }



}
