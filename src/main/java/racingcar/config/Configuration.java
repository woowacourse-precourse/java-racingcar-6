package racingcar.config;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.converter.InputConverter;
import racingcar.io.reader.InputReader;
import racingcar.io.reader.StdReader;
import racingcar.io.writer.OutputWriter;
import racingcar.io.writer.StdWriter;
import racingcar.move.MoveStrategy;
import racingcar.move.NumberGenerator;
import racingcar.move.RandomMoveStrategy;
import racingcar.move.RandomNumberGenerator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Configuration {
    public static GameController getGameController() {
        StdReader reader = new InputReader();
        StdWriter writer = new OutputWriter();

        OutputView outputView = new OutputView(writer);
        InputValidator inputValidator = new InputValidator();
        InputConverter inputConverter = new InputConverter(inputValidator);
        InputView inputView = new InputView(reader, writer, inputConverter);

        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomNumberGenerator);

        return new GameController(inputView, outputView, randomMoveStrategy);
    }

    public static void closeResources() {
        Console.close();
    }
}
