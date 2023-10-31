package racingcar.repository;


import racingcar.domain.Car;

import java.util.List;

public interface Repository<T> {
    List<T> save(String[] inputNames);
    void moveForward(T t, int value);

    void moveForward(Car car, int value);
}
