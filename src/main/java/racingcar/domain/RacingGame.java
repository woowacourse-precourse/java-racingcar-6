package racingcar.domain;

import java.util.Objects;

public class RacingGame {

    private final PlayerMoveList playerMoveList;
    private final RaceCount raceCount;

    public RacingGame(final PlayerMoveList playerMoveList, final RaceCount raceCount) {
        this.playerMoveList = playerMoveList;
        this.raceCount = raceCount;
    }

    public static RacingGame init(PlayerMoveList playerMoveList) {
        return new RacingGame(playerMoveList, RaceCount.init());
    }

    public void move() {
        playerMoveList.move();
        raceCount.increase();
    }

    public boolean isSameCount(RaceCount endCount) {
        return raceCount.equals(endCount);
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
        return Objects.equals(playerMoveList, that.playerMoveList) && Objects.equals(raceCount,
                that.raceCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMoveList, raceCount);
    }
}
