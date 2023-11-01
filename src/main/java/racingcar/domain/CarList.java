package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public List<Car> carList;

    public CarList(){
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList(){
        return carList;
    }


}
