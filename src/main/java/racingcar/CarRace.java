package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> cars = new ArrayList<>();

    public CarRace(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
    public void race() {
        for (Car car : cars) {
            car.run();
        }
    }

}
