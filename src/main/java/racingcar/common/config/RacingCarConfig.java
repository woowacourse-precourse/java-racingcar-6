package racingcar.common.config;

import racingcar.common.io.reader.CommandLineReader;
import racingcar.common.io.reader.Reader;
import racingcar.common.io.writer.CommandLineWriter;
import racingcar.common.io.writer.Writer;
import racingcar.game.RacingGameManager;
import racingcar.game.RacingGameScreen;

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
