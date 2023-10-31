package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultCars {

    private List<ResultCar> resultCars;

    public ResultCars(List<ResultCar> resultCars) {
        this.resultCars = Collections.unmodifiableList(resultCars);
    }

    public List<ResultCar> getResultCars() {
        new ArrayList<>(resultCars);
        return resultCars;
    }
}
