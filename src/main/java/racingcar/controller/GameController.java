package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarGameService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarGameService carGameService;
    private final WinnerService winnerService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carGameService = new CarGameService();
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
        return carGameService.convertGameCountToNumber(inputView.inputGameCount());
    }

    private List<String> initSetting() {
        outputView.printInitGame();
        return carGameService.extractSeperator(inputView.inputCarName());
    }

    private void roundGameProcess(Integer gameCount, List<Car> cars) {
        for (int count = 0; count < gameCount; count++) {
            outputView.printRoundResult(carGameService.roundResult(cars));
        }
    }

    private void initCarInfo(List<String> carNames, List<Car> cars) {
        carGameService.initCarInfo(carNames, cars);
    }

}
