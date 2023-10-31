package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public static List<Car> createCarList() {
        List<Car> carList = new ArrayList<Car>();
        List<String> nameList = UserInput.getCarNames();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
