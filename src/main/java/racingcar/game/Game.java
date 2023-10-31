package racingcar.game;

import racingcar.data.GameData;
import racingcar.execution.GameExecution;

public class Game {
    private final GameData gameData;
    private final GameExecution gameExecution;
    private static final String RACING_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public Game() {
        this.gameData = new GameData();
        this.gameExecution = new GameExecution();
    }

    public void initGameData() {
        gameExecution.printOutputString(RACING_CAR_NAME_INPUT_MESSAGE);
        gameData.initRacingCars(gameExecution.receiveGameInput());

        gameExecution.printOutputString(ATTEMPT_NUMBER_INPUT_MESSAGE);
        gameData.initAttemptData(gameExecution.receiveGameInput());
    }
    public void run() {
        initGameData();
    }
}
