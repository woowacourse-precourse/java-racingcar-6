package racingcar.carRepository;

import racingcar.model.Car;

import java.util.List;


public interface CarRepositoryInterface {
    public void saveCar(Car car);
    public List getCars();
    public void updateCar(Car car , int index);
}
