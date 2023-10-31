package racingcar.model.dao;

import java.util.List;
import racingcar.dto.Car;

public interface CarDao {
    void init();
    void insertCar(Car car);
    void insertTryCount(int tryCount);
    List<Car> selectAllCars();
    void increaseMoveCount(String carName);
}
