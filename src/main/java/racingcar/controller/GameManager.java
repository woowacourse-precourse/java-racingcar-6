package racingcar.controller;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final UserInputHandler userInputHandler = new UserInputHandler();

    public void startGame() {
        try {
            List<String> nameList = userInputHandler.getCarNameList();
            int round = userInputHandler.getGameRound();
            List<Car> carList = createCarList(nameList);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Car> createCarList (List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for(String name: nameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }
}
