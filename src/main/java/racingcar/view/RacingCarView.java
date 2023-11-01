package racingcar.view;

import racingcar.io.CommandLineReader;
import racingcar.io.CommandLineWriter;

public class RacingCarView {
    private final CommandLineReader commandLineReader;
    private final CommandLineWriter commandLineWriter;

    public RacingCarView(CommandLineReader commandLineReader, CommandLineWriter commandLineWriter) {
        this.commandLineReader = commandLineReader;
        this.commandLineWriter = commandLineWriter;
    }
}
