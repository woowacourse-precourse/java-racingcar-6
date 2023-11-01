package racingcar.controller;

import static racingcar.domain.strategy.MovingStrategyType.RANDOM;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.MovingStrategyType;
import racingcar.view.input.MainInputView;
import racingcar.view.output.MainOutputView;

public class MainController {
    private static final MovingStrategy MOVING_STRATEGY = MovingStrategyType.instance(RANDOM);

    public static void play() {
        List<String> carNames = readCarNames();
        int playCount = readPlayCount();
        MainOutputView.printNewLine();

        RacingCarGame racingCarGame = RacingCarGame.of(carNames, playCount);
        racingCarGame.play(MOVING_STRATEGY);

        MainOutputView.printWinningCars(racingCarGame.winningCarDtos());
    }

    private static List<String> readCarNames() {
        MainOutputView.printReadCarNamesScript();
        return MainInputView.readCarNames();
    }

    private static int readPlayCount() {
        MainOutputView.printReadPlayCountScript();
        return MainInputView.readPlayCount();
    }
}
