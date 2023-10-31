package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ArgumentRangeOutOfBoundsException;
import racingcar.exception.NotANumberException;
import java.util.List;

public class GameClientInput {
    private static final int MIN_TOTAL_MOVES = 1;
    private static final int MAX_TOTAL_MOVES = 1_000;
    private static final String DELIMITER = ",";

    public List<String> getNames() {
        String input = Console.readLine();
        return List.of(input.split(DELIMITER));
    }

    public int getTotalMoves() {
        String input = Console.readLine();
        validateContainingDigits(input);
        return convertTotalMoves(input);
    }

    private int convertTotalMoves(String input) {
        int moves = Integer.parseInt(input);
        validateMovesInRange(moves);
        return moves;
    }

    private void validateMovesInRange(int moves) {
        validateLowerRange(moves);
        validateUpperRange(moves);
    }

    private void validateLowerRange(int moves) {
        if (moves < MIN_TOTAL_MOVES) {
            throw new ArgumentRangeOutOfBoundsException();
        }
    }

    private void validateUpperRange(int moves) {
        if (moves > MAX_TOTAL_MOVES) {
            throw new ArgumentRangeOutOfBoundsException();
        }
    }

    private void validateContainingDigits(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotANumberException();
        }
    }
}
