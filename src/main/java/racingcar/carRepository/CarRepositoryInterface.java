package racingcar.carRepository;

import racingcar.model.Car;

import java.util.List;


public interface CarRepositoryInterface {
    public void saveCar(Car car);
    public List getCars();
}
