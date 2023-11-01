package racingcar.view;

import racingcar.constants.GameMessage;
import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.io.CommandLineReader;
import racingcar.io.CommandLineWriter;

public class RacingCarView {
    private final CommandLineReader commandLineReader;
    private final CommandLineWriter commandLineWriter;

    public RacingCarView(CommandLineReader commandLineReader, CommandLineWriter commandLineWriter) {
        this.commandLineReader = commandLineReader;
        this.commandLineWriter = commandLineWriter;
    }

    public RacingCarsDto inputCarName() {
        commandLineWriter.writeLine(GameMessage.INPUT_CAR_NAME);
        String input = commandLineReader.readLine();
        return new RacingCarsDto(input);
    }
    public NumberOfAttemptsDto inputNumberOfAttempts() {
        commandLineWriter.writeLine(GameMessage.INPUT_NUMBER_OF_ATTEMPTS);
        String input = commandLineReader.readLine();
        return new NumberOfAttemptsDto(input);
    }
}
