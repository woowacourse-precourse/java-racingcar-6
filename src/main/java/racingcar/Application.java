package racingcar;

import constant.Message;
import controller.RacingcarController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController(
                new InputView(), new OutputView()
        );

        racingcarController.startGame();
        do {
            racingcarController.playRound();
        } while (!racingcarController.isEnd());
        racingcarController.endGame();
    }
}
