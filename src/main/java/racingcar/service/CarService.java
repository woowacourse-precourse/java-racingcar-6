package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.carRepository.CarRepositoryInterface;
import racingcar.model.Car;

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
        int randomNumber = getRandomNumber();
        List<Car> cars = carRepository.getCars();

    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
