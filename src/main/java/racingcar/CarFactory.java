package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> from(String names) {
        String[] nameArr = names.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : nameArr) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            carList.add(new Car(name.trim()));
        }
        return carList;
    }
}
