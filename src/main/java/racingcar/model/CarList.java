package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void generateCar(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }
}
