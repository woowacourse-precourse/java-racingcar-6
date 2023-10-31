package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    public String[] getCarNames(String input) {
        return input.split(",");
    }

    public List<Car> createCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name, 0));
        }
        return carList;
    }
}
