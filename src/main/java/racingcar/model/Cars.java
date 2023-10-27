package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;


    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars() {
        for (Car car: carList) {
            car.move();
        }
    }

    public List<String> getRoundResult() {
        List<String> result = new ArrayList<>();

        for (Car car: carList) {
            result.add(car.getNameWithPosition());
        }
        return result;
    }
}
