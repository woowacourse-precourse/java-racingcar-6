package racingcar.domain.game;

import racingcar.utils.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final GameConfig gameConfig;
    private NumberGenerator generator;
    private InputView inputView;
    private OutputView outputView;

    public RacingCarGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public void init() {
        generator = gameConfig.numberGenerator();
        inputView = gameConfig.inputView();
        outputView = gameConfig.outputView();
    }

    public void play() {
        String names = readCarNamesFromUser();
        int round = readGameRoundFromUser();
    }

    private String readCarNamesFromUser() {
        outputView.printRequestCarNames();
        return inputView.readCarNames();
    }

    private int readGameRoundFromUser() {
        outputView.printRequestGameRound();
        return inputView.readGameRound();
    }
}
