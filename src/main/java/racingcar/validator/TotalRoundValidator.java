package racingcar.validator;

import static racingcar.constants.ValidatorConstant.*;

public class TotalRoundValidator implements Validator {
    @Override
    public void validate(String totalRound) {
        if (isBlank(totalRound) || isNotNumeric(totalRound)) {
            throw new IllegalArgumentException(TOTAL_ROUND_ERROR_MESSAGE);
        }
    }

    private boolean isBlank(String totalRound) {
        return totalRound == null || totalRound.isBlank();
    }

    private boolean isNotNumeric(String totalRound) {
        return !totalRound.chars()
                .allMatch(Character::isDigit);
    }
}