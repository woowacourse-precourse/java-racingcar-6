package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarService {
    private final CarRepository carRepository;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FOWARD_CONDITION = 4;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveAllCars(List<Car> cars) {
        carRepository.saveAll(cars);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void FowardCars(){
        List<Car> cars = getAllCars();
        for(Car car : cars){
            if (FOWARD_CONDITION <= getRandomNumber()){
                car.moveFoward();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
