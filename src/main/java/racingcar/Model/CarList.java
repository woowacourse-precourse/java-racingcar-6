package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;
    public CarList(){
        this.cars = new ArrayList<>();
    }
    public void addCar(Car newCar){
        this.cars.add(newCar);
    }
}
