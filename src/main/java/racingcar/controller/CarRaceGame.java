package racingcar.controller;


import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.utility.GameExecutionUtility;
import racingcar.utility.GameSettingUtility;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;
import static camp.nextstep.edu.missionutils.Console.*;

public class CarRaceGame {
    private GameManager gameManager;
    private GameExecutionUtility carRaceGameUtility;

    private CarRaceGame() {
    }

    public static void run() {
        startGame();
    }

    public static void startGame() {
        List<String> carNameList = GameSettingUtility.getCarNameListAndValidate();
        GameSettingUtility.setCarImpls(carNameList);

        GameExecutionUtility.executeCarRaceGameForNRound(GameSettingUtility.getGameRoundAndValidate());

        List<String> winnerList = GameExecutionUtility.findWinner(GameManager.getCarImplList());
        CarRaceGameView.printGameResult(winnerList);

        endGame();
    }




    public static void endGame() {
        close();
    }
}

