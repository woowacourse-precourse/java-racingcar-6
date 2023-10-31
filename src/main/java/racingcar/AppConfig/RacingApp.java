package racingcar.AppConfig;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {

    private GameController gameController;

    public void run() {
        RacingConfig racingConfig = new RacingConfig();
        gameController = new GameController(racingConfig.refereeService(), racingConfig.controlTowerService());

        List<Car> carList = requestInputCarNames();
        int roundNumber = requestInputRoundNumber();

        Map<Integer, List<String>> recordMap = requestStartRacingGame(carList, roundNumber);
        List<String> winnerList = requestFindWinner(carList);

        printRecord(recordMap);
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

    private Map<Integer, List<String>> requestStartRacingGame(List<Car> car, int roundNumber) {
        return gameController.startRacingGame(car, roundNumber);
    }

    private void printRecord(Map<Integer, List<String>> record) {
        OutputView.printRecord(record);
    }

    private List<String> requestFindWinner(List<Car> carList) {
        return gameController.addResultRecord(carList);
    }
}
