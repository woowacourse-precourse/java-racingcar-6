package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRecord;

public class CarRepository {
    public static int IDENTITY_NUMBER = 0;
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

    public void save(CarRecord carRecord) {
        int id = carRecord.id();
        Car updateCar = new Car(
                IDENTITY_NUMBER++,
                carRecord.name(),
                carRecord.position()
        );
        cars.set(id, updateCar);
    }

}
