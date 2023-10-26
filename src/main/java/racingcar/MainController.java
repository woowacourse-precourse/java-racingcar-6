package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.message.ViewMessage;
import racingcar.view.InputView;

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
        List<String> carNames = Converter.splitByDelimiter(InputView.inputString(ViewMessage.INPUT_CAR_NAME), ",");
        List<Car> carList = carNames.stream().map(Car::new).toList();
        return new GameData(
                carList,
                InputView.inputInteger(ViewMessage.INPUT_TRIAL_COUNT)
        );
    }

    private void proceedGame(GameData gameData) {
        int moveCount  = 0;
        while (moveCount++ < gameData.trialCount()) {
//            service.move(gameData.carNames());
//            OutputView.printResult(gameData.racerList());
        }
    }

    private void endGame(GameData gameData) {
//        OutputView.printWinner(gameData);
    }
}
