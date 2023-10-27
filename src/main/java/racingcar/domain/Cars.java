package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.CarNameValidator.*;

public class Cars {
    private static final String COMMA = ",";

    private final List<String> carNames;

    // Cars Constructor
    private Cars(final String input) {
        validateNull(input);
        validateWhiteSpace(input);
        validateEndsWithTab(input);
        validateEndsWithComma(input);
        validateEndsWithNewLine(input);

        this.carNames = parseInput(input);
    }

    // Cars Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    private List<String> parseInput(final String input) {
        return Arrays.stream(input.split(COMMA))
                .toList();
    }
}
