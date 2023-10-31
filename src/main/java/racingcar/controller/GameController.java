package racingcar.controller;

import static racingcar.constant.CommonConstant.ONE_BLANK_LINE;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.game.Game;
import racingcar.dto.Car;
import racingcar.view.InputVeiw;
import racingcar.view.OutputView;

public class GameController {
    private Game game;
    private static CarInfo carinfo = CarInfo.getInstance();

    public GameController() {
        this.game = new Game();
    }

    public void run() {
        getRequest();
        forwardAndResponse();
    }

    private void getRequest() {
        OutputView.printInputMessageCarInfo();
        carinfo.allSaveCarInfo(InputVeiw.inputMultipleNames());

        OutputView.printInputMessageTotalRound();
        game.saveTotalRound(InputVeiw.inputSingleNumber());
    }

    private void forwardAndResponse() {
        OutputView.printBlankLine(ONE_BLANK_LINE);
        OutputView.printOutputMessageResult();

        List<Car> gameWinners = game.playGame();
        OutputView.printGameWinner(gameWinners);
    }
}