package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingGame {

    private GameSetting gameSetting = new GameSetting();
    private ScriptHandler scriptHandler = new ScriptHandler();
    private GameController gameController = new GameController();
    private ArrayList<Car> cars;
    private ArrayList<String> winnerList = new ArrayList<>();
    private int attemptNumber, carNumber, carMoveMent, randomNumber, updateCarValue;
    private String carName;

    public void GameStart() {
        scriptHandler.printGetCarNameScript();
        cars = gameSetting.createCarName();
        scriptHandler.printGetAttemptScript();
        attemptNumber = gameSetting.createAttemptNumber();
        carNumber = cars.size();

        gameProgress(attemptNumber);
    }

    public void gameProgress(int attemptNumber) {
        System.out.println();
        scriptHandler.printSimpleResultScript();
        for (int i = 0; i < attemptNumber; i++) {
            for (int j = 0; j < carNumber; j++) {
                cars.get(j).pickRandomNumber();
                scriptHandler.printCarMovement(cars, j);
            }
            System.out.println();
        }
        checkWinner();
        printWinner();
    }

    public void checkWinner() {
        int furthestMovement = findFurthestMovement();
        for (int i = 0; i < cars.size(); i++) {
            carName = gameController.getCarName(i);
            carMoveMent = gameController.getCarMoveForward(carName);
            if (carMoveMent == furthestMovement) {
                winnerList.add(carName);
            }
        }
    }

    public int findFurthestMovement() {
        int max = -1;
        for (int i = 0; i < cars.size(); i++) {
            carName = gameController.getCarName(i);
            carMoveMent = gameController.getCarMoveForward(carName);
            if (carMoveMent > max) {
                max = carMoveMent;
            }
        }
        return max;
    }

    public void printWinner() {
        if (winnerList.size() == 1) {
            printSoloWinner();
        }
        if (winnerList.size() > 1) {
            printJointWinner();
        }
    }

    public void printSoloWinner() {
        System.out.printf("최종 우승자 : %s", winnerList.get(0));
    }

    public void printJointWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size() - 1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(winnerList.size() - 1));
    }

}
