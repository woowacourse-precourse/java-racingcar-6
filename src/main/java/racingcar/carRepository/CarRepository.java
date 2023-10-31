package racingcar.carRepository;

import racingcar.model.Car;

import java.util.List;

public class CarRepository implements CarRepositoryInterface{

    private  List<Car> carStorage;
    @Override
    public void saveCar(Car car) {
        carStorage.add(car);
    }

    @Override
    public List getCars() {
        return carStorage;
    }
}
