package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class Generator {

    public static Race makeRace(String inputNames) {
        List<Car> carList = stringToCarList(inputNames);
        return new Race(carList);
    }

    public static List<Car> stringToCarList(String input) {
        Validation.nullInEnd(input);
        List<Car> list = new ArrayList<>();
        List<String> names = new ArrayList<>();

        String[] nameArray = stringToStringArray(input);
        for (String name : nameArray) {
            Validation.nameLength(name);
            Validation.duplication(names, name);
            list.add(new Car(name));
            names.add(name);
        }

        Validation.empty(list);
        return list;
    }

    public static String[] stringToStringArray(String input) {
        return input.split(",");
    }

    public static int stringToInteger(String inputNumber) {
        Validation.isNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
