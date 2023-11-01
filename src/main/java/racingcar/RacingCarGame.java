package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<String> carNameList;
    private List<Car> carList;

    public RacingCarGame() {
        carNameList = new ArrayList<>();
        carList = new ArrayList<>();
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

    public List<String> getCarNameList() {
        return carNameList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
