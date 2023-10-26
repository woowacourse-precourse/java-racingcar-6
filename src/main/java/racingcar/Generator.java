package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Generator {

    public static List<Car> carList(String input) {
        List<Car> list = new ArrayList<>();
        for (String name : input.split(",")) {
            Validation.nameLength(name);
            list.add(new Car(name));
        }

        Validation.checkEmpty(list);
        return list;
    }
}
