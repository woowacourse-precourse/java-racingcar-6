package racingcar.view;

import racingcar.constants.GameMessage;
import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.dto.output.ResultOfGameDto;
import racingcar.dto.output.ResultOfTurnDto;
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
    public void printResultMessage() {
        commandLineWriter.writeSpaceLine();
        commandLineWriter.writeLine(GameMessage.EXECUTION_RESULT_MESSAGE);
    }
    public void printRacingCarName(ResultOfTurnDto resultOfTurnDto) {
        commandLineWriter.write(resultOfTurnDto.racingCarName());
    }
    public void printAdvanceMark(ResultOfTurnDto resultOfTurnDto) {
        commandLineWriter.writeLine(resultOfTurnDto.advanceMarking());
    }
    public void printColon() {
        commandLineWriter.write(GameMessage.COLON);
    }
    public void printWinners(ResultOfGameDto resultOfGameDto) {
        commandLineWriter.write(GameMessage.NOTICE_OF_WINNER + GameMessage.COLON);
        for (int i = 0; i < resultOfGameDto.winnerName().size(); i++) {
            if (!(i == 0)) {
                commandLineWriter.write(", ");
            }
            commandLineWriter.write(resultOfGameDto.winnerName().get(i));
        }
    }
    public void printSpaceLine() {
        commandLineWriter.writeSpaceLine();
    }
}
