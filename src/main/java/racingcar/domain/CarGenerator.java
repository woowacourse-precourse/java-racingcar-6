package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public CarGenerator() {
    }

    public List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        UserInput userInput = new UserInput();
        List<String> nameList = userInput.setCarNames();
        for (String name : nameList) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
