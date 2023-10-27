package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.constant.ErrorMessage;

public final class Winners {

    private static final String MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private final List<String> winnerNames;

    public Winners(final List<String> winnerNames) {
        validate(winnerNames);
        this.winnerNames = Collections.unmodifiableList(winnerNames);
    }

    private void validate(final List<String> winnerNames) {
        if (winnerNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNER_NUM.toValue());
        }
    }

    public String toResultMessage() {
        return MESSAGE_PREFIX + String.join(WINNER_DELIMITER, winnerNames);
    }
}
