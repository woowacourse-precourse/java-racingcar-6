package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingcarController {
    public static ArrayList<String> carNames;
    public static HashMap<String, Integer> carsMap;
    public static int numberOfTries;
    public static int maxDistance = 0;
    public static String winners;

    public void playGame() {
        carNames = Car.inputNames();
        carsMap = Car.makeMap(carNames);
        numberOfTries = Race.inputNumberOfTries();
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            raceCar();
            System.out.print("\n");
        }
        winners = takeWinners();
        OutputView.printWinners(winners);
    }

    public void raceCar() {
        for (String carName : carsMap.keySet()) {
            int randomNumber = Race.generateRandomNumber();
            int beforeMove = carsMap.get(carName);
            int afterMove = beforeMove + Race.moveForward(randomNumber);
            carsMap.put(carName, afterMove);
            OutputView.printResultOfRace(carName, carsMap.get(carName));
        }
    }

    public String takeWinners() {
        ArrayList<String> winnersList = new ArrayList<>();

        takeMaxDistance();
        for (String carName : carsMap.keySet()) {
            if (carsMap.get(carName) == maxDistance) {
                winnersList.add(carName);
            }
        }

        return String.join(", ", winnersList);
    }

    public void takeMaxDistance() {
        for (String carName : carsMap.keySet()) {
            if (carsMap.get(carName) > maxDistance) {
                maxDistance = carsMap.get(carName);
            }
        }
    }
}
