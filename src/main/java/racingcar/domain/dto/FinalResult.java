package racingcar.domain.dto;

import java.util.List;
import racingcar.domain.Car;

public class FinalResult {
    private final List<Car> carList;

    private FinalResult(List<Car> carList) {
        this.carList = carList;
    }

    public static FinalResult create(List<Car> carList) {
        return new FinalResult(carList);
    }

    public String getNameString() {
        return String.join(", ",
                carList.stream()
                        .map(Car::getName)
                        .toList());
    }
}
