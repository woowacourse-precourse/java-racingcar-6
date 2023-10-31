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
        List<String> nameList = controller.getNames(inputView.getLine());
        outputView.printAskNumber();
        int howMany = controller.getHowMany(inputView.getLine());
        controller.makeCarList(nameList);
        outputView.printResult();
        controller.play(howMany);
        List<String> winners = controller.whoWinner();
        outputView.printWinner(winners);
    }
}
