package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private CarNameManager carNameManager;
    private CarMovingCountManager carMovingCountManager;
    private List<Car> carList;
    private int movingCount;

    public RacingCarGame() {
        carList = new ArrayList<>();
        carNameManager = new CarNameManager();
        carMovingCountManager = new CarMovingCountManager();
        movingCount = 0;
    }

    public void createCar(String carName) {
        carNameManager.splitCarName(carName);

        List<String> carNameList = carNameManager.getCarNameList();

        for (int i = 0; i < carNameList.size(); i++) {
            Car car = new Car(carNameList.get(i), 0);
            carList.add(car);
        }
    }

    public void saveMovingCount(int movingCount) {
        this.movingCount = movingCount;
    }

    public void setCarMovingCountManager() {
        carMovingCountManager.saveCarMovingCount(carList);
    }

    public boolean isGameOver() {
        if (carMovingCountManager.isGameOver(movingCount)) {
            return true;
        }
        return false;
    }

    public String getWinnerName() {
        List<String> winner = new ArrayList<>();
        List<Integer> carMovingCountList = carMovingCountManager.getCarMovingCountList();

        for (int i = 0; i < carMovingCountList.size(); i++) {
            if (carMovingCountList.get(i) == movingCount) {
                Car oneCar = carList.get(i);
                winner.add(oneCar.getCarName());
            }
        }

        return String.join(", ", winner);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public CarNameManager getCarNameManager() {
        return carNameManager;
    }

    public CarMovingCountManager getCarMovingCountManager() {
        return carMovingCountManager;
    }
}
