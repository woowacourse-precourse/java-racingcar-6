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

    public int getMaxDistance() {
        for (Car car : carList) {
            this.maxDistance = Math.max(this.maxDistance, car.getDistance());
        }
        return maxDistance;
    }

}
