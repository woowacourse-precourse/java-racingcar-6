package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private List<Car> carList;
    private List<String> winnerList;
    private int maxDistance = Integer.MIN_VALUE;


    public CarGroup(String[] names) {
        carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
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
