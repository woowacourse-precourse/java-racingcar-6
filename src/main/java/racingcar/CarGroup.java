package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private List<Car> carList;
    private List<String> winnerList;


    public CarGroup(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerList() {
        winnerList = new ArrayList<>();
        for (Car car : carList) {
            int max = getMaxDistance();
            if (car.getDistance() == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

}
