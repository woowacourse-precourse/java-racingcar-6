package racingcar;

import racingcar.data.GameData;
import racingcar.execution.GameExecution;

public class Game {
    private final GameData gameData;
    private final GameExecution gameExecution;

    public Game() {
        this.gameData = new GameData();
        this.gameExecution = new GameExecution();
    }

    public void initGameData() {
        String racingCarNameData = gameExecution.fetchRacingCarName();
        gameData.initRacingCarName(racingCarNameData);

        String attemptNumberData = gameExecution.fetchAttemptNumber();
        gameData.initAttemptData(attemptNumberData);
    }

    public void proceed() {
        gameExecution.printAttemptResultMessage();
        int attemptNumber = gameData.getAttemptNumber();
        for (int i = 0; i < attemptNumber; i++) {
            gameData.proceedOneRace();
            gameExecution.printAttemptResult(gameData.findLastAttempt());
        }
    }

    public void announceResult() {
        String result = gameData.produceResult();
        gameExecution.printGameResult(result);
    }

    public void run() {
        initGameData();
        proceed();
        announceResult();
    }
}
