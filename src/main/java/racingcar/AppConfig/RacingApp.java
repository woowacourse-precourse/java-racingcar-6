package racingcar.AppConfig;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.ControlTower;
import racingcar.domain.Referee;
import racingcar.service.ControlTowerService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;

public class RacingApp {

    private GameController gameController;

    public RefereeService refereeService() {
        return new RefereeService(referee());
    }

    public Referee referee() {
        return new Referee();
    }

    public ControlTowerService controlTowerService() {
        return new ControlTowerService(controlTower());
    }

    public ControlTower controlTower() {
        return new ControlTower();
    }

    public void run() {
        gameController = new GameController(refereeService(), controlTowerService());

        List<Car> carList = requestInputCarNames();
        int roundNumber = requestInputRoundNumber();
        Map<Integer, List<String>> recordMap = startRacingGame(carList, roundNumber);

    }

    private List<Car> requestInputCarNames() {
        InputView.printCarNameInputRequest();
        return gameController.addCarNames(Console.readLine());
    }

    private int requestInputRoundNumber() {
        return gameController.addRoundNumber(Console.readLine());
    }

    private Map<Integer, List<String>> startRacingGame(List<Car> car, int roundNumber) {
        return gameController.startRacingGame(car, roundNumber);
    }
}
