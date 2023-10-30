package racingcar.model.cycle;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import racingcar.model.car.Car;
import racingcar.model.car.CarManager;
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

    public void runActionInLoop(final Consumer<List<Car>> printSingleRaceResult , final Supplier<List<Car>> action) {
        LongStream.range(START_COUNT, this.count)
                .forEach(i -> printSingleRaceResult.accept(action.get()));
    }

    public Long getCount() {
        return count;
    }
}
