package racingcar;

import racingcar.controller.GameController;
import racingcar.converter.InputConverter;
import racingcar.domain.game.move.RandomMoveStrategy;
import racingcar.domain.game.move.RandomNumberGenerator;
import racingcar.util.InputValidator;
import racingcar.util.MoveStrategy;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputConverter inputConverter = new InputConverter();
        InputView inputView = new InputView(inputValidator, inputConverter);
        OutputView outputView = new OutputView();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomNumberGenerator);
        GameController gameController = new GameController(inputView, outputView, randomMoveStrategy);
        gameController.run();
    }
}
