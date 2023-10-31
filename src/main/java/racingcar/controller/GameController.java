package racingcar.controller;

import static racingcar.constant.CommonConstant.ONE_BLANK_LINE;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.game.GameManager;
import racingcar.dto.Car;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

public class GameController {
    private GameManager gameManager;
    private static CarInfo carinfo = CarInfo.getInstance();

    public GameController() {
        this.gameManager = new GameManager();
        run();
    }

    private void run() {
        getRequest();
        forwardAndResponse();
    }

    private void getRequest() {
        OutputView.printInputMessageOfCarInfo();
        carinfo.saveAllCarInfo(InputVeiw.inputMultipleNames());

        OutputView.printInputMessageOfTotalRound();
        gameManager.saveTotalRoundOfGame(InputVeiw.inputSingleNumber());
    }

    private void forwardAndResponse() {
        OutputView.printBlankLine(ONE_BLANK_LINE);
        OutputView.printOutputMessageResult();

        List<Car> gameWinners = gameManager.startGame();
        OutputView.printGameWinner(gameWinners);
    }
}