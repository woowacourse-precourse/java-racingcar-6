package racingcar.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.global.CharacterSymbol;
import racingcar.io.utils.StringLiteralValidator;

public class ConsoleReader {

    private static final String CAR_NAME_DELIMITER = CharacterSymbol.COMMA.getLiteral();

    public List<String> readCarNames() {
        String input = readLine();

        List<String> delimited = parseByDelimiter(input);

        validateBlankCharacterNotIncluded(delimited);

        return delimited;
    }

    public long readMovingCount() {
        String input = readLine();

        StringLiteralValidator.validateIsPositiveInteger(input);

        return Long.parseLong(input);
    }

    private List<String> parseByDelimiter(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    private void validateBlankCharacterNotIncluded(List<String> literals) {
        if (hasBlankCharacter(literals)) {
            throw new IllegalArgumentException(
                    "Some elements of %s are blank character.".formatted(Arrays.toString(literals.toArray()))
            );
        }
    }

    private boolean hasBlankCharacter(List<String> literals) {
        return literals.stream()
                .anyMatch(literal -> literal.equals(CharacterSymbol.BLANK.getLiteral()));
    }

    private String readLine() {
        return Console.readLine();
    }

}
