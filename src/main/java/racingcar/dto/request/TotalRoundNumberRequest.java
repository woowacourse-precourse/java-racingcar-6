package racingcar.dto.request;

import racingcar.exception.UserInputException;

import static racingcar.config.GameConfig.MIN_TOTAL_ROUND;
import static racingcar.exception.errorcode.UserInputErrorCode.INVALID_TOTAL_ROUND_RANGE;

public class TotalRoundNumberRequest {
    private final int totalCount;

    public TotalRoundNumberRequest(final int totalCount) {
        validateRoundCount(totalCount);
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    private void validateRoundCount(final int totalCount) {
        if (totalCount < MIN_TOTAL_ROUND) {
            throw new UserInputException(INVALID_TOTAL_ROUND_RANGE);
        }
    }
}
