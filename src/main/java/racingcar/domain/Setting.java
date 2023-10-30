package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    static List<Car> cars = new ArrayList<>();

    public static List<Car> initCar() {
        List<String> carNames = Input.getSplitList(Input.inputString());
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
