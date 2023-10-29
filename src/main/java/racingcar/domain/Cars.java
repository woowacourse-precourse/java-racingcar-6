package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private Map<String, Car> cars = new HashMap<>();

    public Map<String, Car> getCars() {
        return cars;
    }
}

