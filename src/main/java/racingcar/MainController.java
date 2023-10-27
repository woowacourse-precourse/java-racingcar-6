package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameData;
import racingcar.message.ViewMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    public void run() {
        GameData gameData = initGame();
        proceedGame(gameData);
        endGame(gameData);
    }

    private GameData initGame() {
        List<Car> carList = Converter.splitByDelimiter(InputView.inputString(ViewMessage.INPUT_CAR_NAME), ",")
                .stream()
                .map(Car::new)
                .toList();

        return new GameData(
                new Cars(carList),
                InputView.inputInteger(ViewMessage.INPUT_TRIAL_COUNT)
        );
    }

    private void proceedGame(GameData gameData) {
        int moveCount  = 0;
        OutputView.printMessage(ViewMessage.GAME_RESULT);
        while (moveCount++ < gameData.trialCount()) {
            gameData.cars()
                    .moveRandomly();
            OutputView.printResult(gameData.cars());
        }
    }

    private void endGame(GameData gameData) {
        List<Car> winner = gameData.cars()
                .getWinnerList();
        OutputView.printWinner(winner);
    }
}
