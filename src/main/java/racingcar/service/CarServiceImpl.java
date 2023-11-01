package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void join(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void moveCarToForward(Long id) {
        carRepository.findById(id).moveForward();
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
}
