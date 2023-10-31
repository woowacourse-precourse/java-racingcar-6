package racingcar.model.dao;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.Car;

public class CarDaoImpl implements CarDao {
    private static CarDao instance = new CarDaoImpl();
    private List<Car> carLineup = new ArrayList<>();

    private CarDaoImpl() {}

    public static CarDao getInstance() {
        return instance;
    }

    public void insertCar(Car car) {
        carLineup.add(car);
    }
}
