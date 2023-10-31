package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private List<Car> carList;
    private List<String> winnerList;
    private int maxDistance = Integer.MIN_VALUE;


    public CarGroup(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerList() {
        winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getDistance() == this.maxDistance) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public int getMaxDistance() {
        for (Car car : carList) {
            this.maxDistance = Math.max(this.maxDistance, car.getDistance());
        }
        return maxDistance;
    }

}
