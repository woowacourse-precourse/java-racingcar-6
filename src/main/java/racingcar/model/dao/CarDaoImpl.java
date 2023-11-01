package racingcar.model.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.dto.Car;

public class CarDaoImpl implements CarDao {
    private static CarDao instance = new CarDaoImpl();
    private List<Car> carLineup = new ArrayList<>();
    private int tryCount = 0;

    private CarDaoImpl() {
    }

    public static CarDao getInstance() {
        return instance;
    }

    @Override
    public void init() {
        carLineup = new ArrayList<>();
        tryCount = 0;
    }

    @Override
    public void insertCar(Car car) {
        carLineup.add(car);
    }

    @Override
    public void insertTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    @Override
    public List<Car> selectAllCars() {
        return carLineup;
    }

    @Override
    public void increaseMoveCount(String carName) {
        for (Car car : carLineup) {
            if (car.getName().equals(carName)) {
                car.increaseMoveCount();
            }
        }
    }

    @Override
    public void decreaseTryCount() {
        tryCount--;
    }

    @Override
    public int getTryCount() {
        return tryCount;
    }

    @Override
    public int selectTopMoveCount() {
        return carLineup.stream()
                .max(Comparator.comparing(Car::getMoveCount))
                .get()
                .getMoveCount();
    }

    @Override
    public List<Car> selectCarsByTopMoveCount() {
        int maxMoveCount = selectTopMoveCount();

        List<Car> topCars = carLineup.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .toList();
        return topCars;
    }
}
