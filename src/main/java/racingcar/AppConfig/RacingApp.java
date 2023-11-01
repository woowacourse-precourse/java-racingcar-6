package racingcar.AppConfig;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.dto.GameRecordDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingApp {

    private GameController gameController;

    public void run() {
        RacingConfig racingConfig = new RacingConfig();
        gameController = new GameController(racingConfig.refereeService(), racingConfig.controlTowerService());

        List<Car> carList = requestInputCarNames();
        int roundNumber = requestInputRoundNumber();

        GameRecordDto gameRecord = requestStartRacingGame(carList, roundNumber);
        List<String> winnerList = requestFindWinner(gameRecord.getCars());

        printRecord(gameRecord.getRecord());
        printWinner(winnerList);
    }

    private List<Car> requestInputCarNames() {
        InputView.printCarNameInputRequest();
        return gameController.addCarNames(Console.readLine());
    }

    private int requestInputRoundNumber() {
        InputView.printRoundNumberInputRequest();
        return gameController.addRoundNumber(Console.readLine());
    }

    private GameRecordDto requestStartRacingGame(List<Car> car, int roundNumber) {
        return gameController.startRacingGame(car, roundNumber);
    }

    private List<String> requestFindWinner(List<Car> carList) {
        return gameController.addResultRecord(carList);
    }

    private void printRecord(Map<Integer, List<String>> record) {
        OutputView.printRecord(record);
    }

    private void printWinner(List<String> winnerList) {
        OutputView.printWinner(winnerList);
    }
}
