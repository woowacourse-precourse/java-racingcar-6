package racingcar.model.dao;

import racingcar.dto.Car;

public interface CarDao {
    void insertCar(Car car);
    void insertTryCount(int tryCount);
}
