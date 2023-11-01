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

    public void gameHandler() {
        try {
            List<Car> cars = new ArrayList<>();
            List<String> carNames = inputCarNames();
            Integer gameRound = getTotalGameRound();
            initCarInfo(carNames, cars);
            notifyBeforeResult();
            roundGameProcess(gameRound, cars);
            outputView.printWinners(winnerService.findWinners(cars));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void notifyBeforeResult() {
        outputView.notifyInitRoundResult();
    }

    private Integer getTotalGameRound() {
        outputView.printBeforeInputGameRound();
        return carRaceService.convertGameRoundToNumber(inputView.inputGameRound());
    }

    private List<String> inputCarNames() {
        outputView.printInitGame();
        return carRaceService.extractSeperator(inputView.inputCarName());
    }

    private void roundGameProcess(Integer gameRound, List<Car> cars) {
        for (int nowRound = 1; nowRound <= gameRound; nowRound++) {
            outputView.printRoundResult(carRaceService.roundResult(cars));
        }
    }

    private void initCarInfo(List<String> carNames, List<Car> cars) {
        carRaceService.initCarInfo(carNames, cars);
    }

}
