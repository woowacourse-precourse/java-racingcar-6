package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> elements = new ArrayList<>();

    public Cars(List<String> names) {
        names.forEach(name -> elements.add(new Car(name)));
    }
}
