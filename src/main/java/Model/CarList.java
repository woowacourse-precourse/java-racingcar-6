package Model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getSize() {
        return carList.size();
    }

    public Car getCar(int idx) {
        return carList.get(idx);
    }
}
