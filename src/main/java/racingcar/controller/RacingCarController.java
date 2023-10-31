package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarValidateService;
import racingcar.vIew.InputView;
import racingcar.vIew.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final RacingCarValidateService racingCarValidateService = new RacingCarValidateService();
    private List<String> winners;

    public void gamePlay() {
        String carsName = inputCarNames();
        Cars cars = createCars(carsName);
        int numberOfGames = inputNumberOfGame();
        gameResult(cars, numberOfGames);
        gameWinnerResult(cars);
    }

    public String inputCarNames() {
        String carNames = inputView.inputCars();
        racingCarValidateService.validateInputCarName(carNames);
        return carNames;
    }

    public Cars createCars(String carsName) {
        return racingCarService.generateCars(carsName);
    }

    public int inputNumberOfGame() {
        String numberOfGame = inputView.inputNumberOfGame();
        racingCarValidateService.validateInputNumberOfGame(numberOfGame);
        return Integer.parseInt(numberOfGame);
    }

    public void gameResult(Cars cars, int numberOfGame) {
        outputView.gameResultMessageOutput();
        for (int i = 0; i < numberOfGame; i++) {
            outputView.gameReslutOutput(racingCarService.judgeResult(cars.getCarsStatus()));
        }
    }

    public void gameWinnerResult(Cars cars) {
        winners = racingCarService.judgeWinners(cars.getCarsStatus());
        outputView.WinnerOutput(winners);
    }

}
