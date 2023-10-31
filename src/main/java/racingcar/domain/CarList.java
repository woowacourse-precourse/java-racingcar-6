package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> cars = new ArrayList<>();

    private static CarList instance = new CarList();

    private CarList(){}

    public static CarList getInstance() {
        return instance;
    }

    public List<Car> getCars() {
        return cars;
    }
}
