package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public final class Positions { //final class

    private final List<Integer> positions = new ArrayList<>();

    private Positions() {

    }

    public static Positions create() {
        return new Positions();
    }

    public int calcLastIndex() {
        return positions.size()-1;
    }

    public int calcLastPosition() {
        return positions.get(calcLastIndex());
    }

    public int calcMaxPosition() {
        return positions.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int findPositionAt(int turn) {
        return positions.get(turn);
    }

    public boolean isPositionSameOrOver(int maxPosition) {
        return calcLastPosition() >= maxPosition;
    }

    public void moveForward() {
        positions.set(calcLastIndex(), calcLastPosition() + 1);
    }
}
