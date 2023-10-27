package racingcar.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

public class RacingGame {
    private static final int INITIAL_SKIP_COUNT = 1;
    private final CarGroup carGroup;
    private final TryCount tryCount;

    private RacingGame(CarGroup carGroup, TryCount tryCount) {
        this.carGroup = carGroup;
        this.tryCount = tryCount;
    }

    public static RacingGame initialize(CarGroup carGroup, TryCount tryCount) {
        return new RacingGame(carGroup, tryCount);
    }

    public MoveHistory playWith(MovementCondition movementCondition) {
        return Stream.iterate(carGroup, carGroup -> carGroup.move(movementCondition))
                .skip(INITIAL_SKIP_COUNT)
                .limit(tryCount.getCount())
                .collect(collectingAndThen(toList(), MoveHistory::from));
    }
}
