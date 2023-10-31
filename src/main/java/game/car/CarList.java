package game.car;

import java.util.ArrayList;
import java.util.Collections;

public class CarList {
    private final ArrayList<Car> carList;

    public CarList(String inputString) {
        carList = new ArrayList<>();
        for (String s : inputString.split(",")) {
            this.add(new Car(s));
        }
    }

    private void add(Car car) {
        carList.add(car);
    }

    public ArrayList<Car> getCarList() {
        return (ArrayList<Car>) Collections.unmodifiableList(this.carList);
    }
}
