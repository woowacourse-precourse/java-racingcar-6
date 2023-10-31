package racingcar.view;

import racingcar.enums.Messages;

public class OutputView {
    public void printInputRacingCar() {
        System.out.println(Messages.INPUT_RACING_CAR_MESSAGE.getMessage());
    }

    public void printInputTryNumber() {
        System.out.println(Messages.INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }
}
