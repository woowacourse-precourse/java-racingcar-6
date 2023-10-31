package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.util.RacingGameUtil;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class GameController {

    public void run() {
        String carNames = getCarNameFromUser();
        Cars cars = new Cars(carNames);
        Integer gameCycleNumber = getGameCycleNumberFromUser();

        playRacingGame(gameCycleNumber, cars);
    }

    private void playRacingGame(Integer gameCycleNumber, Cars cars) {
        RacingGame racingGame = new RacingGame(gameCycleNumber, cars);

        OutputManager.printGameStart();
        racingGame.playGame();
    }

    private Integer getGameCycleNumberFromUser() {
        InputManager.requestGameCycleNumber();
        Integer gameCycleNumber = RacingGameUtil.transferGameCycleType(Console.readLine());
        return gameCycleNumber;
    }

    private String getCarNameFromUser() {
        InputManager.requestCarName();
        return Console.readLine();
    }
}
