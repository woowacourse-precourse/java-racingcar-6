package racingcar.domain;

import java.util.Objects;

public class RacingGame {

    private final RaceRound raceRound;
    private final RaceCount raceCount;

    private RacingGame(final RaceRound raceRound, final RaceCount raceCount) {
        this.raceRound = raceRound;
        this.raceCount = raceCount;
    }

    public static RacingGame init(final RaceRound raceRound) {
        return new RacingGame(raceRound, RaceCount.init());
    }

    public static RacingGame from(RaceRound raceRound, RaceCount raceCount) {
        return new RacingGame(raceRound, raceCount);
    }

    public void move() {
        raceRound.move();
        raceCount.increase();
    }

    public boolean isSameCount(final RaceCount finishCount) {
        return raceCount.equals(finishCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingGame that = (RacingGame) o;
        return Objects.equals(raceRound, that.raceRound) && Objects.equals(raceCount,
                that.raceCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceRound, raceCount);
    }
}
