package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarMovingCountManager {

    private List<Integer> carMovingCountList;

    public CarMovingCountManager() {
        carMovingCountList = new ArrayList<>();
    }

    public void saveCarMovingCount(List<Car> carList) {
        carMovingCountList.clear();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int carMovingCount = car.getMovingCount();
            carMovingCountList.add(carMovingCount);
        }
    }

    public boolean isGameOver(int movingCount) {
        for (int i = 0; i < carMovingCountList.size(); i++) {
            if (carMovingCountList.get(i) == movingCount) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getCarMovingCountList() {
        return carMovingCountList;
    }
}
