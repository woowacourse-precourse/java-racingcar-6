package racingcar;

import java.util.List;
import racingcar.view.InputView;

public class Controller {

    private final InputView inputView;
    private RacingGame racingGame;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        racingGame = new RacingGame(carNames);
    }
}