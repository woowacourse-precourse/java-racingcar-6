package racingcar.model;

import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public int size() {
        return carList.size();
    }
}
