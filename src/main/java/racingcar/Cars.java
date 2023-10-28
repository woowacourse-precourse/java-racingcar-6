package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(String names) {
        String[] splitNames = names.split(",");
        cars = Arrays.stream(splitNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
