package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private List<Car> resultList = new ArrayList<>();

    public void add(Car car) {
        resultList.add(car);
    }

    public List<Car> getResultList() {
        return resultList;
    }
}
