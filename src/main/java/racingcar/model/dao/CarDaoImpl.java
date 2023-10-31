package racingcar.model.dao;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.Car;

public class CarDaoImpl implements CarDao {
    private static CarDao instance = new CarDaoImpl();
    private List<Car> carLineup = new ArrayList<>();
    private int totalTryCount = 0;

    private CarDaoImpl() {}

    public static CarDao getInstance() {
        return instance;
    }

    @Override
    public void insertCar(Car car) {
        carLineup.add(car);
    }

    @Override
    public void insertTryCount(int tryCount) {
        totalTryCount = tryCount;
    }
}
