package racingcar;

import racingcar.controller.Controller;
import racingcar.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
//        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller();


        outputView.printAskName();
        List<String> nameList = controller.getNames();
        outputView.printAskNumber();
        int howMany = controller.getHowMany();
        controller.putCarList(nameList);
        outputView.printResult();
        controller.play(howMany);
        List<String> winners = controller.whoWinner();
        outputView.printWinner(winners);

    }
}
