package racingcar.game;

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
        gameData.initRacingCars(racingCarNameData);

        String attemptNumberData = gameExecution.fetchAttemptNumber();
        gameData.initAttemptData(attemptNumberData);
    }

    public void proceed() {
        gameData.proceedOneRace();
    }

    public void run() {
        initGameData();
        proceed();
    }
}
