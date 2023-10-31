package utils;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.MovingCount;
import model.Name;

public class Converter {

    private Converter() {
    }

    public static List<Car> convertNameToCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(new Name(name), new MovingCount(0)))
                .collect(Collectors.toList());
    }
}
