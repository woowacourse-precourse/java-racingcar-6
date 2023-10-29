package domain;

import java.util.Arrays;
import java.util.List;

public class Car {

    public List<String> convertCarName(String carName) {
        List<String> carNames = Arrays.asList(carName.split(","));
        return carNames;
    }
}
