package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.vIew.InputView;
import racingcar.vIew.OutputView;

public class RacingCarController {
    private static final String PLAY_GAME_STATUS = "PLAYING";
    private static final String END_GAME_STATUS = "END";

    private String carNames;
    private int numberOfGames;
    private List<String> winners;
    private RacingCarService racingCarService = new RacingCarService();

    public void gamePlay() {
        inputCarNames();
        createCars();
        inputNumberOfGame();
        gameResultMessage();
        gameResult();
    }

    public void inputCarNames() {
        carNames = InputView.inputCars();
    }

    public void createCars(){
        racingCarService.createCars(carNames);
    }
    public void inputNumberOfGame() {
        numberOfGames = InputView.inputNumberOfGame();
    }


    public void gameResultMessage() {
        OutputView.gameResultMessageOutput();
    }

    public void gameResult() {
        for (int i = 0; i < numberOfGames; i++) {
            OutputView.gameReslutOutput(racingCarService.judgeResult());
        }
    }

    public void gameWinnerResult() {
        winners =
        OutputView.WinnerOutput(winners);

    }


}
