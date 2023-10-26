package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    private final RacingService service;

    public MainController(RacingService service) {
        this.service = service;
    }

    public void run() {
        GameData gameData = initGame();
        proceedGame(gameData);
        endGame(gameData);
    }

    private GameData initGame() {
        List<String> carNames = Converter.splitByDelimiter(InputView.inputString(Message.INPUT_CAR_NAME), ",");
        return new GameData(
                carNames,
                InputView.inputInteger(Message.INPUT_TRIAL_COUNT)
        );
    }

    private void proceedGame(GameData gameData) {
        int moveCount  = 0;
        while (moveCount++ < gameData.trialCount()) {
            service.move(gameData.carNames());
//            OutputView.printResult(gameData.racerList());
        }
    }

    private void endGame(GameData gameData) {
//        OutputView.printWinner(gameData);
    }
}
