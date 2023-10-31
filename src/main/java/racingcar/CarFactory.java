package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            validateName(name);
            carList.add(new Car(name));
        }
        return carList;
    }

    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
