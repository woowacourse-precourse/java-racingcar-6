package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.Validation;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final CarInfo carInfo = new CarInfo();

    private int convertStringToInt(String num) {
        Validation.checkTryNumber(num);
        return Integer.parseInt(num);
    }

    private void tryMove() {
        int carNum = carInfo.getCarName().size();
        for(int i = 0; i < carNum; i++) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            carInfo.updateCarStatus(carInfo.isMove(randomNum), i);
        }
    }

    public void racingStart() {
        int tryNum;

        carInfo.setCarName(InputView.receiveCarName());
        carInfo.initCarStatus();
        tryNum = convertStringToInt(InputView.receiveTryNumber());

        OutputView.printExecResult();
        for(int i = 0; i < tryNum; i++) {
            tryMove();
            OutputView.printCarStatus(carInfo.getCarName(), carInfo.getCarStatus());
        }
        OutputView.printWinner(carInfo.getWinnerName());
    }



}
