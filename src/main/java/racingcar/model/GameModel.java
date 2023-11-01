package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameModel {

    public List<String> generateCarName(String carNames) {

        List<String> carNameList = Arrays.asList(carNames.split(","));
        HashMap<String, String> carHashMap = new HashMap<>();

        return carNameList;
    }

    public List<Car> generateCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); i++) {
            carList.add(new Car(carNameList.get(i)));
        }

        return carList;
    }

    public List<String> findWinner(List<Car> carList) {
        List<String> winner = new ArrayList<>();
        int topMovement = 0;

        for (Car car : carList) {
            int carMovement = car.getDistance();

            if (carMovement > topMovement) {
                topMovement = carMovement;
                winner.clear();
                winner.add(car.getName());
            } else if (carMovement == topMovement) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}
