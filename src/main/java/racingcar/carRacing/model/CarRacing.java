package racingcar.carRacing.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.model.Car;

public class CarRacing {

    private List<Car> cars = new ArrayList<Car>();

    public CarRacing() {
    }

    public void initCarList(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return cars;
    }

}
