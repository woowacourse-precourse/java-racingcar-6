package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void carCreator(List<String> inputCarNameList){
        for(String carName : inputCarNameList){
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}
