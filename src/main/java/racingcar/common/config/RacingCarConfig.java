package racingcar.common.config;

import racingcar.game.RacingGameManager;
import racingcar.game.RacingGameScreen;
import racingcar.io.reader.CommandLineReader;
import racingcar.io.reader.Reader;
import racingcar.io.writer.CommandLineWriter;
import racingcar.io.writer.Writer;

public class RacingCarConfig {

    public RacingGameManager getRacingGameManager() {
        final Reader reader = getReader();
        final Writer writer = getWriter();
        RacingGameScreen racingGameScreen = getRacingGameScreen(reader, writer);
        return new RacingGameManager(racingGameScreen);
    }

    private RacingGameScreen getRacingGameScreen(Reader reader, Writer writer) {
        return new RacingGameScreen(reader, writer);
    }

    private Reader getReader() {
        return new CommandLineReader();
    }

    private Writer getWriter() {
        return new CommandLineWriter();
    }
}
