package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRecord;

public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public Car findById(int id) {
        return cars.get(id);
    }

    public int findIdByCar(Car car) {
        return cars.indexOf(car);
    }

    public List<Car> findAll() {
        return cars;
    }

    public void save(CarRecord carRecord) {
        int id = carRecord.id();
        Car updateCar = new Car(
                id,
                carRecord.name(),
                carRecord.position()
        );
        cars.set(id, updateCar);
    }

}
