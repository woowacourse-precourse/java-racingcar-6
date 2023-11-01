package racingcar.controller;

import racingcar.config.GameConfig;
import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.view.InputView;

import java.util.List;

import static racingcar.util.GameInputReader.readExistLine;
import static racingcar.util.GameInputReader.readInt;
import static racingcar.util.InputConvertUtils.carNamesToNameList;

public class RacingCarGame {

    private MovingStrategy movingStrategy;

    public RacingCarGame(GameConfig gameConfig) {
        this.movingStrategy = gameConfig.getMovingStrategy();
    }

    public void play() {
        InputView.printDemandCarNames();
        Cars cars = new Cars(readCarNames());

        InputView.printDemandAttemptCount();
        Attempt attempt = new Attempt(readInt());
    }

    private static List<String> readCarNames() {
        return carNamesToNameList(readExistLine());
    }
}
