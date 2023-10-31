package racingcar.common.config;

import racingcar.game.RacingGameManager;
import racingcar.game.RacingGameScreen;
import racingcar.io.reader.CommandLineReader;
import racingcar.io.reader.Reader;
import racingcar.io.writer.CommandLineWriter;
import racingcar.io.writer.Writer;

public class RacingCarConfig {
    private Reader reader;
    private Writer writer;

    public RacingGameManager getRacingGameManager() {
        reader = getReader();
        writer = getWriter();
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

    public void close() {
        reader.close();
    }
}
