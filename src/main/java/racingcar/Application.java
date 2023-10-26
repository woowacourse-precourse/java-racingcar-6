package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String userInputCarsName = inputView.askCarsName();
        System.out.println(userInputCarsName);

        String userInputTrialTimes = inputView.askTrialTimes();
        System.out.println(userInputTrialTimes);
    }
}
