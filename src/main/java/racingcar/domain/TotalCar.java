package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.CarCondition;

public class TotalCar {
    private final List<Car> carList = new ArrayList<>();

    public void saveNewCar(String name) {
        Car car = new Car(name);
        carList.add(car);
    }

    public void moveDistance() {
        CarCondition condition = new CarCondition();
        for (Car c : carList) {
            if (condition.isMove()) {
                c.updateDistance(1);
            }
        }
    }

    public List<String> nameList() {
        List<String> carNames = new ArrayList<>();
        for (Car c : carList) {
            carNames.add(c.getName());
        }
        return carNames;
    }

    public List<Integer> distanceList() {
        List<Integer> carDistance = new ArrayList<>();
        for (Car c : carList) {
            carDistance.add(c.getDistance());
        }
        return carDistance;
    }
}