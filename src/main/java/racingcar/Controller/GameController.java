package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.View.OutputView;

public class GameController {
    private InputController inputController;
    private GameController gameController;
    int rounds;

    public GameController() {
        initialize();
        initiateGame();
        displayWinners();
    }

    public void initialize(){

        rounds = inputController.getRoundCount();
    }

    public void initiateGame() {
        OutputView.printPlayMessage();

    }
    public void displayWinners() {
        cars.showWinners();
    }
}
