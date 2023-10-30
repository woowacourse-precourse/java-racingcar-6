package racingcar.config;

import io.reader.StdReader;
import io.writer.StdWriter;
import number.RandomNumberPicker;
import racingcar.component.ComponentWriter;
import racingcar.controller.GameController;
import racingcar.domain.move.RandomMoveCommander;
import racingcar.parser.InputParser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class Configuration {

    private Configuration() {
    }

    public static GameController getDefaultGameController() {
        final ComponentWriter componentWriter = new ComponentWriter(new StdWriter());
        final StdReader reader = new StdReader();
        final InputView inputView = new InputView(
                new InputParser(
                        new InputValidator()),
                componentWriter,
                reader);

        return new GameController(
                inputView,
                new OutputView(componentWriter),
                new RandomMoveCommander(
                        new RandomNumberPicker()
                )
        );
    }
}
