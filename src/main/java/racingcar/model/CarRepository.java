package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> carList = new ArrayList<Car>();

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<Car>();
        for (Car car : carList) {
            if (car.getGo() == carList.size()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
