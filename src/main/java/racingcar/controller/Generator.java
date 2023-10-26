package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Generator {

    public static List<Car> carList(String input) {
        List<Car> list = new ArrayList<>();
        List<String> names = new ArrayList<>();

        for (String name : input.split(",")) {
            Validation.nameLength(name);
            Validation.duplication(names, name);
            list.add(new Car(name));
            names.add(name);
        }

        Validation.empty(list);
        return list;
    }
}
