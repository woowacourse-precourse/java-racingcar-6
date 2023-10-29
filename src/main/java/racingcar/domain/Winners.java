package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.Collections;
import java.util.List;

public final class Winners {

    private static final String MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private final List<String> names;

    public Winners(final List<String> names) {
        validate(names);
        this.names = Collections.unmodifiableList(names);
    }

    private void validate(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNER_NUM.toValue());
        }
    }

    public String toResultMessage() {
        return MESSAGE_PREFIX + String.join(WINNER_DELIMITER, names);
    }
}
