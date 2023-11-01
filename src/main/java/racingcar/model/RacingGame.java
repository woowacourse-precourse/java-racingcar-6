package racingcar.model;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public final class RacingGame {
    private static final int INITIAL_SKIP_COUNT = 1;

    private final CarGroup carGroup;
    private final TryCount tryCount;

    private RacingGame(CarGroup carGroup, TryCount tryCount) {
        this.carGroup = carGroup;
        this.tryCount = tryCount;
    }

    public static RacingGame of(CarGroup carGroup, TryCount tryCount) {
        return new RacingGame(carGroup, tryCount);
    }

    public RaceHistory startRaceWith(MovementCondition movementCondition) {
        List<RaceStage> raceStages = generateRaceStages(movementCondition);
        return RaceHistory.from(raceStages);
    }

    private List<RaceStage> generateRaceStages(MovementCondition movementCondition) {
        return Stream.iterate(carGroup, carGroup -> carGroup.moveAll(movementCondition))
                .skip(INITIAL_SKIP_COUNT)
                .limit(tryCount.getCount())
                .map(RaceStage::from)
                .collect(toList());
    }
}
