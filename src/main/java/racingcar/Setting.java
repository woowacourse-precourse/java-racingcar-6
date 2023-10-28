package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Setting {

    private final List<Car> cars;
    private int round = 0;

    public Setting() {
        this.cars = new ArrayList<>();
    }

    public void initializeCars(String carNames) {
        List<String> carNameList = CarSeparator.separate(carNames);
        for (String carName : carNameList) {
            this.cars.add(new Car(carName));
        }
    }

    public void initializeRound(String round) {
        this.round = Integer.parseInt(round);
    }

    public void tryCarsForward() {
        for (Car car : this.cars) {
            car.tryForward();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
