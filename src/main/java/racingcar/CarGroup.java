package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> carList;
    private List<Car> winnerList;
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

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

}
