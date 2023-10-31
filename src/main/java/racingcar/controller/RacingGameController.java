package racingcar.controller;

import racingcar.constants.GameInfo;
import racingcar.model.CarList;
import racingcar.util.GameUtil;
import racingcar.view.OutputView;

public class RacingGameController {
    private CarList carList;
    private int roundNum;
    private static int maxPosition;

    public void run() {
        init();
        play();
        end();
    }

    public void init() {
        carList = InputController.initCarList();
        roundNum = InputController.initRoundNum();
        maxPosition = 0;
    }

    public void play() {
        OutputView.printResultHeader();
        for (int i = 0; i < roundNum; i++) {
            carList.moveAll();
            carList.printAll();
            GameUtil.printRoundSeperator();
        }
    }

    public void end() {
        OutputView.printWinner(carList.getWinners());
    }

    public static void updateMaxPosition(int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
    }

    public static int getMaxPosition() {
        return maxPosition;
    }
}
