package racingcar.view;

import io.reader.Reader;
import racingcar.component.ComponentWriter;
import racingcar.component.in.MaxRoundComponent;
import racingcar.component.in.NameComponent;
import racingcar.domain.car.CarsRacing;
import racingcar.parser.InputParser;
import racingcar.validator.InputValidator;

public final class InputView {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    private final ComponentWriter componentWriter;
    private final Reader reader;

    public InputView(
            final InputValidator inputValidator,
            final InputParser inputParser,
            final ComponentWriter componentWriter,
            final Reader reader
    ) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.componentWriter = componentWriter;
        this.reader = reader;
    }

    public CarsRacing inputCarsRacing() {
        componentWriter.write(new NameComponent());
        final String input = reader.readLine();
        inputValidator.validateCarNamesInput(input);

        return inputParser.parseToCarsRacing(input);
    }

    public int inputMaxRound() {
        componentWriter.write(new MaxRoundComponent());
        final String input = reader.readLine();
        inputValidator.validateMaxRoundInput(input);

        return inputParser.parseToMaxRound(input);
    }
}
