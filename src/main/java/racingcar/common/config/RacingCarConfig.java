package racingcar.common.config;

import racingcar.game.RacingGameManager;
import racingcar.game.RacingGameScreen;
import racingcar.io.reader.ConsoleReader;
import racingcar.io.reader.Reader;
import racingcar.io.writer.ConsoleWriter;
import racingcar.io.writer.Writer;
import racingcar.util.Random;

public class RacingCarConfig {

    public RacingGameManager getRacingGameManager() {
        final Random random = getRandom();
        final Reader reader = getReader();
        final Writer writer = getWriter();
        RacingGameScreen racingGameScreen = getRacingGameScreen(reader, writer);
        return new RacingGameManager(random, racingGameScreen);
    }

    private RacingGameScreen getRacingGameScreen(Reader reader, Writer writer) {
        return new RacingGameScreen(reader, writer);
    }

    private Reader getReader() {
        return new ConsoleReader();
    }

    private Writer getWriter() {
        return new ConsoleWriter();
    }

    private Random getRandom() {
        return new Random();
    }
}
