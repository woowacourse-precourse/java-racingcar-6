package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public int size() {
        return carList.size();
    }

    public Cars(String input) {
        List<Car> list = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String name : splitInput) {
            list.add(new Car(name));
        }
        this.carList = list;
    }

    public void moveForwardValueOf(int index) {
        carList.get(index).moveForward();
    }
}
