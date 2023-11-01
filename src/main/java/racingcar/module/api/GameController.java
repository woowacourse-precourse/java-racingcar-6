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
        setGame();
    }

    public void setGame() {
        Output.printEnterCarNamesMessage();
        List<String> carNames = Input.readCarNames();
        Output.printEnterTrialMessage();
        int trial = Input.readTrialNumber();

        gameService.setGame(carNames, trial);
    }

}
