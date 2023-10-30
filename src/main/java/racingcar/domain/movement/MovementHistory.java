package racingcar.domain.movement;

import java.util.Objects;

public class MovementHistory {
    private int movedDistance;

    public int getMovedDistance() {
        return movedDistance;
    }

    public void recordMovement(boolean couldMove) {
        if (couldMove) {
            movedDistance += 1;

        }
    }

    public boolean isMaxDistance(int maxDistance) {
        return Objects.equals(movedDistance, maxDistance);
    }
}
