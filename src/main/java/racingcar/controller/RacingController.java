package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.ExceptionCheck;
import racingcar.model.CarModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private CarController carController;
    private int repeatNumber;

    public void carNamesProcess() {
        OutputView.printCarNameDemand();
        List<String> carList = Arrays.asList(InputView.inputCarName().split(","));

        this.carController = new CarController(carList);
    }

    public void repeatNumberProcess() {
        OutputView.printRepeatNumberDemand();
        repeatNumber = Integer.parseInt(InputView.inputRepeatNumber());
        ExceptionCheck.iterateNumberValidation(repeatNumber);
    }

    public void racingStart() {
        OutputView.printResult();
        for (int i = 0; i < repeatNumber; i++) {
            carController.carForward();
        }
    }

    public void resultWinner() {
        OutputView.printWinner(carController.winnerCheck(repeatNumber));
    }
}
