package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarValidateService;
import racingcar.vIew.InputView;
import racingcar.vIew.OutputView;

public class RacingCarController {
    private static final String PLAY_GAME_STATUS = "PLAYING";
    private static final String END_GAME_STATUS = "END";

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
        carNames = InputView.inputCars();
        racingCarValidateService.validateInputCarName(carNames);

    }

    public void createCars() {
        racingCarService.createCars(carNames);
    }

    public void inputNumberOfGame() {
        numberOfGames = InputView.inputNumberOfGame();
        racingCarValidateService.validateInputNumberOfGame(numberOfGames);
    }


    public void gameResultMessage() {
        OutputView.gameResultMessageOutput();
    }

    public void gameResult() {
        for (int i = 0; i < Integer.parseInt(numberOfGames); i++) {
            OutputView.gameReslutOutput(racingCarService.judgeResult());
        }
    }

    public void gameWinnerResult() {
        winners = racingCarService.judgeWinners();
        OutputView.WinnerOutput(winners);
    }

}
