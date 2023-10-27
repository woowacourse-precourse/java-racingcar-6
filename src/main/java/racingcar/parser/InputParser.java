package racingcar.parser;

import static strings.Strings.COMMAS;
import static strings.Strings.WHITE_SPACE;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.CarRacing;
import racingcar.domain.car.CarsRacing;
import racingcar.validator.InputValidator;

public final class InputParser {

    private final InputValidator inputValidator;

    public InputParser(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public CarsRacing parseToCarsRacing(final String input) {
        inputValidator.validateCarNamesInput(input);

        final List<CarRacing> cars = Arrays.stream(input.split(COMMAS + WHITE_SPACE))
                .map(CarRacing::new)
                .toList();

        return CarsRacing.from(cars);
    }

    public int parseToMaxRound(final String input) {
        inputValidator.validateMaxRoundInput(input);
        return Integer.parseInt(input);
    }
}
