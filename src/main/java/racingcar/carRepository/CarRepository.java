package racingcar.carRepository;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements CarRepositoryInterface{

    private  List<Car> carStorage = new ArrayList<>();
    @Override
    public void saveCar(Car car) {
        carStorage.add(car);
    }

    @Override
    public List getCars() {
        return carStorage;
    }

    @Override
    public void updateCar(Car car, int index) {
        carStorage.set(index,car);
    }
}
