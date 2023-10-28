package racingcar.service;

import racingcar.model.CarRepository;
import racingcar.model.car.Car;

public class CarSaveService {

    private CarSaveService(){

    }
    public static CarRepository SaveCars(String[] strings, CarRepository carRepository){
        for(int i = 0; i< strings.length; i++) {
            Car participantCar = Car.of(i, strings[i]);
            carRepository.save(participantCar);
        }
        return carRepository;
    }


}
