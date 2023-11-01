package racingcar;

import Controller.CarRacingGameController;
import view.CarRacingGameView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRacingGameView view = new CarRacingGameView();
        List<String> carNames = view.getCarNames();
        int numOfAttempts = view.getNumberOfAttempts();
        CarRacingGameController controller = new CarRacingGameController(carNames);
        List<String> winners = controller.playGame();
        view.printWinners(winners);
    }
}
