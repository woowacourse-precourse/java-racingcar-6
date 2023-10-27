package racingcar.domain;

import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : carList) {
            builder.append(car.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
