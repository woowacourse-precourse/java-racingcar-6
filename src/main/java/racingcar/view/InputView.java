package racingcar.view;

import io.reader.Reader;
import racingcar.component.ComponentWriter;
import racingcar.component.input.MaxRoundComponent;
import racingcar.component.input.NameComponent;
import racingcar.domain.car.CarsRacing;
import racingcar.domain.game.boxed.MaxRound;
import racingcar.parser.InputParser;

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
