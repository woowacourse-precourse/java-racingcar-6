package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultCars {

    private final List<ResultCar> values;

    public ResultCars(final List<ResultCar> values) {
        this.values = Collections.unmodifiableList(values);
    }

    public List<ResultCar> getValues() {
        new ArrayList<>(values);
        return values;
    }
}
