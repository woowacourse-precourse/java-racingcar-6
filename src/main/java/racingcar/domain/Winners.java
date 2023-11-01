package racingcar.domain;

import racingcar.constant.Delimiter;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ProgressMessage;

import java.util.Collections;
import java.util.List;

public final class Winners {

    private final List<Name> names;

    public Winners(final List<Name> names) {
        validate(names);
        this.names = Collections.unmodifiableList(names);
    }

    private void validate(final List<Name> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNER_NUM.toValue());
        }
    }

    public String toResultMessage() {
        return ProgressMessage.WINNERS_MESSAGE_PREFIX.toValue()
                + String.join(Delimiter.BLANK_AFTER_COMMA.toExpression(), namesToValue());
    }

    private List<String> namesToValue() {
        return names.stream().map(Name::toValue).toList();
    }
}
