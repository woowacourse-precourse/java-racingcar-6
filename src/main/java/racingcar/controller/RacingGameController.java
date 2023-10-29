package racingcar.controller;

import java.util.Map;
import java.util.Set;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.Logs;
import racingcar.domain.Position;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.racingGameService = new RacingGameService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Cars cars = racingGameService.generateCars(inputView.readCars());
        Count carsGameCount = racingGameService.generateCarsGameCount(inputView.readCarsGameCount());
        Map<String, Integer> carsMap = cars.getMaps();
        int count = carsGameCount.getCount();
        Position position = racingGameService.generateCarsPosition(carsMap, count);
        Logs logs = racingGameService.generateCarsGameLogs(carsMap);

        start(position, logs,count);
        finish(position,count);
    }

    private void start(Position position, Logs carsGameLogs, int count) {
        outputView.printGameResultMessage();
        for (int i = 0; i < count; i++) {
            Map<String, String> logs = racingGameService.getUpdatedLogs(position, carsGameLogs);
            responseCarsGameLogs(logs);
        }
    }

    private void finish(Position carsPosition, int count) {
        Map<String, Integer> position = carsPosition.getPosition();
        String winners = racingGameService.checkWinner(position, count);
        outputView.printWinner(winners);
    }

    private void responseCarsGameLogs(Map<String, String> logs) {
        Set<String> cars = logs.keySet();
        for (String car : cars) {
            String log = logs.get(car);
            outputView.printGameLog(car, log);
        }
        System.out.println("");
    }
}
