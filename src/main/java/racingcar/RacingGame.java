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
        scriptHandler.printWinner(winnerList);
    }
}
