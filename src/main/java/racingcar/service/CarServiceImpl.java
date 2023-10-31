package racingcar.service;

import racingcar.constant.GameConstantValue;
import racingcar.entity.Car;
import racingcar.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    // DI
    private final CarRepository carRepository;
    private Long id = 0L;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void createCar(String name) {
        Car car = new Car(id++, name, 0);
        carRepository.create(car);
    }

    @Override
    public boolean isValidValue(int randomValue) {
        if (randomValue >= GameConstantValue.STANDARD) {
            return true;
        }
        return false;
    }

    public void moveForward(Long carId) {
        carRepository.update(carId);
    }

    public List<Car> getListOfCar() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getChampions() {
        List<Car> cars = getListOfCar();
        List<Car> champions = new ArrayList<>();

        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                champions.clear();
                champions.add(car);
                continue;
            }
            if (car.getDistance() == maxDistance) {
                champions.add(car);
            }
        }
        return champions;
    }
}
