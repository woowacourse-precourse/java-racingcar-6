package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.Validate;

public class Cars{
    private List<Car> cars;
    public Cars(List<Car> cars) {
        Validate.carNamesDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size(){
        return cars.size();
    }
}
