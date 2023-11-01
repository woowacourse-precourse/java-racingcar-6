package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public class ProgressState {
    private final List<Car> carList;

    private ProgressState(List<Car> carList) {
        this.carList = carList;
    }

    public static ProgressState create(List<Car> carList) {
        return new ProgressState(carList);
    }

    public List<Car> cars() {
        return carList;
    }
}
