package racingcar.model.cycle;

import racingcar.utils.validator.RaceCountValidator;
import racingcar.utils.validator.Validator;

public class RaceCount {

    private final static Long START_COUNT = 0L;

    private final Long count;

    public RaceCount(final String count) {
        this(count, new RaceCountValidator());
    }

    public RaceCount(final String count, final Validator<String> validator) {
        validator.validate(count);
        this.count = Long.parseLong(count);
    }

    public RaceCount(final Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }
}
