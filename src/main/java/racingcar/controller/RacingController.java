package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.ExceptionCheck;
import racingcar.model.CarModel;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Cars cars;
    private int repeatNumber;

    public void runGame() {
        carNamesProcess();
        repeatNumberProcess();
        racingStart();
        resultWinner();
    }
    private void carNamesProcess() {
        OutputView.printCarNameDemand();
        List<String> carList = Arrays.asList(InputView.inputCarName().split(","));

        this.cars = new Cars(carList);
    }

    private void repeatNumberProcess() {
        OutputView.printRepeatNumberDemand();
        repeatNumber = Integer.parseInt(InputView.inputRepeatNumber());
        ExceptionCheck.iterateNumberValidation(repeatNumber);
    }

    private void racingStart() {
        OutputView.printResult();
        for (int i = 0; i < repeatNumber; i++) {
            cars.carsForward();
        }
    }

    private void resultWinner() {
        OutputView.printWinner(cars.winnerCheck(repeatNumber));
    }
}
