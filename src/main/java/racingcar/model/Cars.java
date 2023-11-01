package racingcar.model;

import java.util.List;

public class Cars {
    CarList carlist = new CarList();

    public void addCar(String names) {
        for (String name : names.split(",")) {
            carlist.add(name);
        }
    }

    public List<Car> getCarList() {
        return carlist.getCarlist();
    }
}
