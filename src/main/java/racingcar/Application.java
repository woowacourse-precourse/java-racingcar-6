package racingcar;

import racingcar.controller.GameController;
import racingcar.handler.UserInputHandler;
import racingcar.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> nameList = UserInputHandler.getNamesFromUser();
        String names = String.join(", ", nameList);
        int rounds = UserInputHandler.getAttemptCountFromUser();

        GameController gameController = new GameController();
        gameController.setUp(names);
        gameController.run(rounds);

        List<String> winners = gameController.getWinners();
        ResultView.printWinners(winners);
    }
}
