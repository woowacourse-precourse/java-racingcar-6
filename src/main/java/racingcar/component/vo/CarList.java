package racingcar.component.vo;

import java.util.ArrayList;
import java.util.List;
import racingcar.component.domain.Car;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(this.carList);
    }
}
