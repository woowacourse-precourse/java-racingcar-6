package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private static ResultRepository instance;
    private List<Car> resultList = new ArrayList<>();

    private ResultRepository() {
    }

    public static ResultRepository getInstance() {
        if (instance == null) {
            instance = new ResultRepository();
        }
        return instance;
    }

    public void add(Car car) {
        resultList.add(car);
    }

    public List<Car> getResultList() {
        return resultList;
    }
}
