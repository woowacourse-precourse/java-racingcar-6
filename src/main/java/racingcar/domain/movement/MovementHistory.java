package racingcar.domain.movement;

import static racingcar.utils.RacingConfig.MOVED_HISTORY_MARK;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovementHistory {
    private int movedDistance;
    private final List<String> movedHistories = new ArrayList<>();

    public int getMovedDistance() {
        return movedDistance;
    }
    public List<String> getMovedHistories() {
        return movedHistories;
    }

    public void recordMovement(boolean couldMove) {
        if (couldMove) {
            movedDistance += 1;
            movedHistories.add(MOVED_HISTORY_MARK);
            return;
        }
        movedHistories.add(" ");
    }

    public boolean isMaxDistance(int maxDistance) {
        return Objects.equals(movedDistance, maxDistance);
    }

}
