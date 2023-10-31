package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller();

        outputView.printAskName();
        List<String> nameList = controller.getEnteredNames(inputView.getLine());
        outputView.printAskNumber();
        int howMany = controller.getAttemptNumber(inputView.getLine());
        controller.makeCarList(nameList);
        outputView.printResult();
        controller.play(howMany);
        outputView.printWinner(controller.whoisWinner());
    }
}
