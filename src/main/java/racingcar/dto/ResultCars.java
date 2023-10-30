package racingcar.dto;

import java.util.List;

public class ResultCars {

    private List<ResultCar> resultCars;

    public ResultCars(List<ResultCar> resultCarList) {
        this.resultCars = resultCarList.stream().toList();
    }

    public List<ResultCar> getResultCars() {
        return resultCars;
    }
}
