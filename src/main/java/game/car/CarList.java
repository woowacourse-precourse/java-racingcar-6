package game.car;

import java.util.ArrayList;

public class CarList {
    ArrayList<Car> carList;

    public CarList(String inputString) {
        carList = new ArrayList<>();
        for (String s : inputString.split(",")) {
            this.add(new Car(s));
        }
    }

    public void add(Car car) {
        carList.add(car);
    }
}
