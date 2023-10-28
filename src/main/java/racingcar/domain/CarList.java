package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private static CarList instance = new CarList();

    private CarList(){}

    public static CarList getInstance() {
        return instance;
    }

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }
}
