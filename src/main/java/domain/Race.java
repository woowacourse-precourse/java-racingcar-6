package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static Race instance = new Race();

    private List<Car> cars;
    private int moveCount;

    private Race() {
        this.cars = new ArrayList<>();
        this.moveCount = 0;
    }

    public static Race getInstance() {
        if (instance == null) {
            instance = new Race();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }


}
