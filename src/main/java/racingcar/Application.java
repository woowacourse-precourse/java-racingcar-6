package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String userInputCarsName = inputView.askCarsName();

        String userInputTrialTimes = inputView.askTrialTimes();
    }
}