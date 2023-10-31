package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Car> parse(String input) {
        List<String> names = Arrays.stream(input.split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        Validator.validateName(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
