package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.RacingCars;
import racingcar.View.OutputView;

public class GameController {
    private int rounds;
    private RacingCars racingCars;

    public GameController() {
        initialize();
        initiateGame();
        displayWinners();
    }

    public void initialize(){
        racingCars = InputController.getCarNames();
        rounds = InputController.getRoundCount();
    }

    public void initiateGame() {
        OutputView.printPlayMessage();

    }
    public void displayWinners() {
//        racingCars.showWinners();
    }
}
