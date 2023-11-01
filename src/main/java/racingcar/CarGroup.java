package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> carList;

    public CarGroup(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            int maxDistance = getMaxDistance();
            if (car.getDistance() == maxDistance) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

}
