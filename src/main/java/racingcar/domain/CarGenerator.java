package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public CarGenerator() {
    }

    public static List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        List<String> nameList = UserInput.getCarNames();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
