package racingcar.module.api;

import java.util.List;
import racingcar.module.application.GameService;
import racingcar.module.view.Input;
import racingcar.module.view.Output;

public class GameController {

    private static final GameController instance = new GameController();
    private static final GameService gameService = GameService.getInstance();

    private GameController() {
    }

    public static GameController getInstance() {
        return instance;
    }

    public void run() throws IllegalArgumentException {
        play(setGame());
    }

    private Long setGame() {
        List<String> carNames = getCarNames();
        int trial = getTrialNumber();

        return gameService.setGame(carNames, trial);
    }

    private void play(Long gameId) {
        Output.printResultMessage();

        while (!gameService.isEnd(gameId)) {
            Output.printScore(gameService.play(gameId));
        }
        Output.printWinners(gameService.getWinners(gameId));
    }

    private List<String> getCarNames() {
        Output.printEnterCarNamesMessage();
        return Input.readCarNames();
    }

    private int getTrialNumber() {
        Output.printEnterTrialMessage();
        return Input.readTrialNumber();
    }

}
