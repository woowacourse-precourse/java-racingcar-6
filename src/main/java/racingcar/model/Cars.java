package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> setPlayer(String rawCarList) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = spiltPlayer(rawCarList);

        addCarNameCarList(carList, carNameArray);
        return carList;
    }

    private String[] spiltPlayer(String rawCarList) {
        return rawCarList.split(",");
    }

    private void addCarNameCarList(List<Car> carList, String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            carList.add(new Car(carNameArray[i], Car.INIT_MOVE));
        }
    }

    public List<Car> raceCars(List<Car> carList) {
        carList.forEach(Car::carMoveOrStay);
        return carList;
    }
}
