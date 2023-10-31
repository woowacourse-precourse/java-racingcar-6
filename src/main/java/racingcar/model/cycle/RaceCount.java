package racingcar.model.cycle;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import racingcar.model.car.Car;
import racingcar.utils.validator.RaceCountValidator;
import racingcar.utils.validator.Validator;

public class RaceCount {

    private final static Integer START_COUNT = 0;

    private final Integer count;

    public RaceCount(final String count) {
        this(count, new RaceCountValidator());
    }

    public RaceCount(final String count, final Validator<String> validator) {
        validator.validate(count);
        this.count = Integer.parseInt(count);
    }

    public RaceCount(final Integer count) {
        this.count = count;
    }

    public void runActionInLoop(final Consumer<List<Car>> printSingleRaceResult, final Supplier<List<Car>> action) {
        IntStream.range(START_COUNT, this.count)
                .forEach(i -> printSingleRaceResult.accept(action.get()));
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceCount raceCount = (RaceCount) o;
        return Objects.equals(count, raceCount.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "RaceCount{" +
                "count=" + count +
                '}';
    }
}
