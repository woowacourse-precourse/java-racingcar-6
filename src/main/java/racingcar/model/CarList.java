package racingcar.model;

import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public String getForwardStateString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getForwardStateString(car));
            sb.append("\n");
        }
        return sb.toString();
    }
}
