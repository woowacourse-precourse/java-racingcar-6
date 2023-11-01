package racingcar.Controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameContoller {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void startGame() {
        List<String> names = makeRacingCars();
        RacingGame game = new RacingGame(names);
        int tryCount = makeTryCount();
        output.printTryMessage();
        for (int i = 0; i < tryCount; i++) {
            game.moveCarForward();
            output.printTryResult(game);
        }
        output.printWinnerMessage();
        output.printWinnerNames(game);
    }

    public List<String> makeRacingCars() {
        output.printNameMessage();
        return input.inputCarNames();
    }

    public int makeTryCount() {
        output.printCountMessage();
        return input.inputTryCount();
    }
}
