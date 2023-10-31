package racingcar.model;

import java.util.ArrayList;

public class CarRepository {
    private ArrayList<Car> racingCars = new ArrayList<Car>();

    private static final CarRepository instance = new CarRepository();

    public void setRacingCars(ArrayList<Car> cars) {
        this.racingCars = cars;
    }

    public static CarRepository getInstance() {
        return instance;
    }

    public void insertCar(Car car) {
        racingCars.add(car);
    }

    public ArrayList<Car> findCarList() {
        return racingCars;
    }
}
