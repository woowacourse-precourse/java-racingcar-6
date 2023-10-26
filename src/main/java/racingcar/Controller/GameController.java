package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.View.OutputView;

public class GameController {
    private InputController inputController;
    private GameController raceController;
    private OutputView raceView;

    public GameController() {
        inputController = new InputController();
        raceView = new OutputView();
        initiateGame();
    }

    public void initiateGame() {
        List<Car> cars = inputController.getCarList();
        int roundCount = inputController.getRoundCount();
        raceController = new RaceController(cars, roundCount, raceView);
        raceController.runRace();
        raceController.displayWinners();
    }
}
