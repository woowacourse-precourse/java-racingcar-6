package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<String> carNameList;
    private List<Car> carList;
    private List<Integer> carMovingCountList;
    private int movingCount;

    public RacingCarGame() {
        carNameList = new ArrayList<>();
        carList = new ArrayList<>();
        carMovingCountList = new ArrayList<>();
        movingCount = 0;
    }

    public void splitCarName(String carName) {
        String[] carNameArray = carName.split(",");

        for (int i = 0; i < carNameArray.length; i++) {
            carNameList.add(carNameArray[i]);
        }
    }

    public void createCar() {
        for (int i = 0; i < carNameList.size(); i++) {
            Car car = new Car(carNameList.get(i), 0);
            carList.add(car);
        }
    }

    public void saveMovingCount(int movingCount) {
        this.movingCount = movingCount;
    }

    public void saveCarMovingCount() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int carMovingCount = car.getMovingCount();
            carMovingCountList.add(carMovingCount);
        }
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getMovingCount() {
        return movingCount;
    }
}
