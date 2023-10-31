package racingcar.AppConfig;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.ControlTower;
import racingcar.domain.GameRecord;
import racingcar.domain.Referee;
import racingcar.service.ControlTowerService;
import racingcar.service.RefereeService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {

    private GameController gameController;

    public RefereeService refereeService() {
        return new RefereeService(referee());
    }

    public Referee referee() {
        return new Referee();
    }

    public ControlTowerService controlTowerService() {
        return new ControlTowerService(controlTower(), gameRecord());
    }

    public ControlTower controlTower() {
        return new ControlTower();
    }

    public GameRecord gameRecord() {
        return new GameRecord();
    }

    public void run() {
        gameController = new GameController(refereeService(), controlTowerService());

        List<Car> carList = requestInputCarNames();
        int roundNumber = requestInputRoundNumber();
        Map<Integer, List<String>> recordMap = startRacingGame(carList, roundNumber);
        printRecord(recordMap);
        List<String> winnerList = requestFindWinner(carList);
        OutputView.printWinner(winnerList);
    }

    private List<Car> requestInputCarNames() {
        InputView.printCarNameInputRequest();
        return gameController.addCarNames(Console.readLine());
    }

    private int requestInputRoundNumber() {
        InputView.printRoundNumberInputRequest();
        return gameController.addRoundNumber(Console.readLine());
    }

    private Map<Integer, List<String>> startRacingGame(List<Car> car, int roundNumber) {
        return gameController.startRacingGame(car, roundNumber);
    }

    private void printRecord(Map<Integer, List<String>> record) {
        OutputView.printRecord(record);
    }

    private List<String> requestFindWinner(List<Car> carList) {
        return gameController.addResultRecord(carList);
    }
}
