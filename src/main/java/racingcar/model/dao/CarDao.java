package racingcar.model.dao;

import java.util.List;
import racingcar.dto.Car;

public interface CarDao {
    void init();
    void insertCar(Car car);
    void insertTryCount(int tryCount);
    void increaseMoveCount(String carName);
    void decreaseTryCount();
    int getTryCount();
    int getTopMoveCount();
    List<Car> selectCarsByMoveCount(int moveCount);
    List<Car> selectAllCars();
}
