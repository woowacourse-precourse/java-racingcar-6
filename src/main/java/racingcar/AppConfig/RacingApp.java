package racingcar.AppConfig;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.service.ControlTowerService;
import racingcar.view.InputView;

public class RacingApp {

    private GameController gameController;

    public ControlTowerService controlTowerService() {
        return new ControlTowerService(new Referee());
    }

    public void run() {
        gameController = new GameController(controlTowerService());

        requestInputGameInfo();
    }

    private void requestInputGameInfo() {
        InputView.printCarNameInputRequest();
        List<Car> cars = gameController.addCarNames(Console.readLine());
        int roundNumber = gameController.addRoundNumber(Console.readLine());
    }
}
