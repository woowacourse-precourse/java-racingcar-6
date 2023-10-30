package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateCarsNumber(carList);
        this.carList = carList;
    }

    public void validateCarsNumber(List<Car> carList) {
        if (carList.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
