package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public List<Car> setPlayer(String rawCarList) {
        String[] carNameArray = spiltPlayer(rawCarList);

        addCarNametoCarList(carNameArray);

        return carList;
    }

    private String[] spiltPlayer(String rawCarList) {
        return rawCarList.split(",");
    }

    private void addCarNametoCarList(String[] carNameArray) {
        for (int i = 0; i < carNameArray.length; i++) {
            carList.add(new Car(carNameArray[i], 0));
        }
    }

    public List<Car> raceCars(List<Car> carList) {
        carList.forEach(car -> car.carMoveOrStay());
        return carList;
    }
}
