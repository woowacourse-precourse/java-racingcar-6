package controller;

import static constant.ConstantNumber.MAX_NUMBER_RANGE;
import static constant.ConstantNumber.MIN_NUMBER_RANGE;
import static constant.ConstantString.EXECUTION_RESULT;

import camp.nextstep.edu.missionutils.Randoms;

import domain.Cars;

import view.InputView;
import view.OutputView;

public class RaceController {
    private Cars cars;

    public void set() {
        cars = new Cars(InputView.carNames());
        start(InputView.attemptCount());
    }

    private void start(int attemptCount) {
        System.out.println(EXECUTION_RESULT);
        race(attemptCount);
        OutputView.printWinners(cars.getWinners());
    }

    private void race(int attemptCount) {
        for (int i = attemptCount; i > 0; i--) {
            cars.MoveCars();
            OutputView.printProcess(cars.getCarsList());
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE.getValue(), MAX_NUMBER_RANGE.getValue());
    }
}
