package racingcar.Controller;

import racingcar.model.CarInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.validation;

import java.util.List;

public class RacingGame {
    private final CarInfo carInfo = new CarInfo();
    public void racingStart() {
        int tryNum;

        carInfo.setCarName(InputView.receiveCarName());
        carInfo.initCarStatus();
        tryNum = convertStringToInt(InputView.receiveTryNumber());

        OutputView.printExecResult();
        for(int i = 0; i < tryNum; i++) {
            carInfo.updateCarStatus();
            OutputView.printCarStatus(carInfo.getCarName(), carInfo.getCarStatus());
        }
        OutputView.printWinner(carInfo.getWinnerName());
    }
    public int convertStringToInt(String num) {
        validation.checkTryNumber(num);
        return Integer.parseInt(num);
    }

}
