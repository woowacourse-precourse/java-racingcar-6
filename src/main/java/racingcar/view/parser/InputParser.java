package racingcar.view.parser;

import static strings.Strings.COMMAS;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.CarRacing;
import racingcar.domain.car.CarsRacing;
import racingcar.domain.round.boxed.MaxRound;
import racingcar.view.validator.InputValidator;

public final class InputParser {

    private final InputValidator inputValidator;

    public InputParser(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public CarsRacing parseToCarsRacing(final String input) {
        inputValidator.validateCarNamesInput(input);

        final List<CarRacing> cars = Arrays.stream(input.split(COMMAS))
                .map(CarRacing::new)
                .toList();

        return CarsRacing.from(cars);
    }

    public MaxRound parseToMaxRound(final String input) {
        inputValidator.validateMaxRoundInput(input);
        return new MaxRound(Integer.parseInt(input));
    }
}
