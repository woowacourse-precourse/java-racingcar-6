package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class RacingController {

    private final RacingService racingService = new RacingService();
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> createCarList() {
        String[] carNames = inputView.inputRacingCar();
        return racingService.createCarList(carNames);
    }

    public void playRacing(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int tryCount = inputView.inputTryCount();
        while (tryCount --> 0) {
            Map<String, Integer> result = racingService.playRacingCar(cars);
            outputView.appendRaceStatus(sb, result);
        }
        outputView.printRaceStatus(sb);
    }

    public void readVictoryPlayers(List<Car> cars) {
        List<String> victoryPlayers = racingService.findByVictoryPlayers(cars);
        outputView.printVictoryPlayers(victoryPlayers);
    }
}
