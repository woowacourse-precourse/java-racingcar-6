package racingcar.view;

import io.reader.Reader;
import racingcar.domain.car.CarsRacing;
import racingcar.domain.round.boxed.MaxRound;
import racingcar.view.component.ComponentWriter;
import racingcar.view.component.input.MaxRoundComponent;
import racingcar.view.component.input.NameComponent;
import racingcar.view.parser.InputParser;

public final class InputView {
    private final InputParser inputParser;
    private final ComponentWriter componentWriter;
    private final Reader reader;

    public InputView(
            final InputParser inputParser,
            final ComponentWriter componentWriter,
            final Reader reader
    ) {
        this.inputParser = inputParser;
        this.componentWriter = componentWriter;
        this.reader = reader;
    }

    public CarsRacing inputCarsRacing() {
        componentWriter.write(new NameComponent());
        return inputParser.parseToCarsRacing(reader.readLine());
    }

    public MaxRound inputMaxRound() {
        componentWriter.write(new MaxRoundComponent());
        return inputParser.parseToMaxRound(reader.readLine());
    }
}
