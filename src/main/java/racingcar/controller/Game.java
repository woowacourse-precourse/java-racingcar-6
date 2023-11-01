package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Game {
    private final Input inputView = new Input();
    private final Output outputView = new Output();
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
