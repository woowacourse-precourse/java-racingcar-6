package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();


        Racing racing = new Racing(inputView.inputName());
        int repeat = inputView.inputTries();

        for(int i = 0; i < repeat; i++) {
            outputView.printCurrentStatus(racing.play());
        }
        outputView.printResult(racing.computeResult());
    }
}
