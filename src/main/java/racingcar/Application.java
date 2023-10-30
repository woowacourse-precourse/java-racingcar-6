package racingcar;

import constant.Message;
import controller.RacingcarController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
    }
}
