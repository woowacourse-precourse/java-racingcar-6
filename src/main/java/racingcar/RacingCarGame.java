package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private CarNameManager carNameManager;
    private List<Car> carList;
    private List<Integer> carMovingCountList;
    private int movingCount;

    public RacingCarGame() {
        carList = new ArrayList<>();
        carMovingCountList = new ArrayList<>();
        carNameManager = new CarNameManager();
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

    public void saveCarMovingCount() {
        carMovingCountList.clear();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int carMovingCount = car.getMovingCount();
            carMovingCountList.add(carMovingCount);
        }
    }

    public boolean isGameOver() {
        saveCarMovingCount();
        for (int i = 0; i < carMovingCountList.size(); i++) {
            if (carMovingCountList.get(i) == movingCount) {
                return true;
            }
        }
        return false;
    }

    public String getWinnerName() {
        List<String> winner = new ArrayList<>();

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

    public List<Integer> getCarMovingCountList() {
        return carMovingCountList;
    }

    public CarNameManager getCarNameManager() {
        return carNameManager;
    }
}
