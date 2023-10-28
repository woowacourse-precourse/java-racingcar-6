package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarValidateService;
import racingcar.vIew.InputView;
import racingcar.vIew.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final RacingCarValidateService racingCarValidateService = new RacingCarValidateService();
    private String carNames;
    private String numberOfGames;
    private List<String> winners;

    public void gamePlay() {
        inputCarNames();
        createCars();
        inputNumberOfGame();
        gameResultMessage();
        gameResult();
        gameWinnerResult();
    }

    public void inputCarNames() {
        carNames = inputView.inputCars();
        racingCarValidateService.validateInputCarName(carNames);

    }

    public void createCars() {
        racingCarService.generateCars(carNames);
    }

    public void inputNumberOfGame() {
        numberOfGames = inputView.inputNumberOfGame();
        racingCarValidateService.validateInputNumberOfGame(numberOfGames);
    }


    public void gameResultMessage() {
        outputView.gameResultMessageOutput();
    }

    public void gameResult() {
        for (int i = 0; i < Integer.parseInt(numberOfGames); i++) {
            outputView.gameReslutOutput(racingCarService.judgeResult());
        }
    }

    public void gameWinnerResult() {
        winners = racingCarService.judgeWinners();
        outputView.WinnerOutput(winners);
    }

}
