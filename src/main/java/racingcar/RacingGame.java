package racingcar;

import java.util.ArrayList;

public class RacingGame {

    private GameSetting gameSetting = new GameSetting();
    private ScriptHandler scriptHandler = new ScriptHandler();
    private Judgement judgement = new Judgement();
    private ArrayList<Car> cars;
    private ArrayList<String> winnerList = new ArrayList<>();
    private int attemptNumber, carNumber;

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
        winnerList = judgement.checkWinner(cars);
        printWinner();
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
