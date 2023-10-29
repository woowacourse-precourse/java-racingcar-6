package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;

import java.util.List;

public final class Numbers {

    private static final int MIN_ELEMENT_NUM = 2;
    private final List<Number> values;

    public Numbers(final List<Integer> values) {
        validate(values);
        this.values = values.stream().map(Number::new).toList();
    }

    private void validate(final List<Integer> values) {
        if (values.size() < MIN_ELEMENT_NUM) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_NUM.toValue());
        }
    }

    public MoveStatus checkMoveStatus(final int index) {
        final Number number = values.get(index);
        return number.checkMoveStatus();
    }
}
