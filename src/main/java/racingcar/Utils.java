package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private List<Car> cars = new ArrayList<>();

    public List<Car> carNames(String input) {

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }

        return cars;
    }
}
