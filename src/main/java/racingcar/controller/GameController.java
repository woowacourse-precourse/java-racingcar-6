package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarRaceService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarRaceService carRaceService;
    private final WinnerService winnerService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carRaceService = new CarRaceService();
        this.winnerService = new WinnerService();
    }

    public void start() {
        try {
            List<Car> cars = new ArrayList<>();
            List<String> carNames = initSetting();
            Integer gameCount = getGameCount();
            initCarInfo(carNames, cars);
            notifyBeforeResult();
            roundGameProcess(gameCount, cars);
            outputView.printWinners(winnerService.findWinners(cars));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void notifyBeforeResult() {
        outputView.notifyBeforeResult();
    }

    private Integer getGameCount() {
        outputView.printBeforeInputGameCount();
        return carRaceService.convertGameCountToNumber(inputView.inputGameCount());
    }

    private List<String> initSetting() {
        outputView.printInitGame();
        return carRaceService.extractSeperator(inputView.inputCarName());
    }

    private void roundGameProcess(Integer gameCount, List<Car> cars) {
        for (int count = 0; count < gameCount; count++) {
            outputView.printRoundResult(carRaceService.roundResult(cars));
        }
    }

    private void initCarInfo(List<String> carNames, List<Car> cars) {
        carRaceService.initCarInfo(carNames, cars);
    }

}
