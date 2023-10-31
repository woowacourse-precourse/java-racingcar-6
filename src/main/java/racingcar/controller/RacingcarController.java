package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingcarController {
    public static ArrayList<String> carNames;
    public static HashMap<String, Integer> carsMap;
    public static int numberOfTries;

    public void startGame() {
        carNames = Car.inputNames();
        carsMap = Car.makeMap(carNames);
        numberOfTries = Race.inputNumberOfTries();
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            System.out.println(i + "--------");
            playGame(carsMap);
        }
    }

    public void playGame(HashMap<String, Integer> carsMap) {
        for (String carName : carsMap.keySet()) {
            int randomNumber = Race.generateRandomNumber();
            int beforeMove = carsMap.get(carName);
            int afterMove = beforeMove + Race.moveCar(randomNumber);
            carsMap.put(carName, afterMove);
        }
    }


    public String takeWinners() {
        return null;
    }
}
