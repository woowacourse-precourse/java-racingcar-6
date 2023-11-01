package racingcar.domain.game;

import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.generator.RandomNumberGenerator;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameConfig {
    public NumberGenerator numberGenerator() {
        return RandomNumberGenerator.getInstance();
    }

    public InputView inputView() {
        return ConsoleInputView.getInstance();
    }

    public OutputView outputView() {
        return ConsoleOutputView.getInstance();
    }
}
