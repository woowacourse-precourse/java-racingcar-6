package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String inputNames) {

        String[] names = inputNames.split(",");
        cars = Arrays.stream(names)
                .map(name -> new Car(name))
                .toList();
    }
}
