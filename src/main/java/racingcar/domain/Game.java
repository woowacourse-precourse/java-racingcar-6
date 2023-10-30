package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Racing racing = new Racing();

    private final static int MIN_TRY_NUM = 1;

    public void run() {
        outputView.printCarNameInputGuide();
        List<String> carNameList = inputView.InputCarName();

        outputView.printTryNumInputGuide();
        int tryNum = inputView.InputTryNum();

        List<Car> cars = racing.toCarList(carNameList);

        outputView.printResultMessage();
        while (tryNum >= MIN_TRY_NUM) {
            racing.initCarsRandomNum(cars);
            racing.modifyForwardNum(cars);
            outputView.printRacingResult(cars);
            tryNum--;
        }

        List<String> winnerList = racing.findWinners(cars);
        outputView.printWinner(winnerList);
    }
}
