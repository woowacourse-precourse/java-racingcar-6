package racingcar;

import java.util.ArrayList;
import java.util.List;

public class DataTypeChanger {
    public static List<String> stringToList(String names) {
        names = names.replace(" ", "");
        return List.of(names.split(","));
    }

    public static List<Car> stringToCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));
        return cars;
    }
}
