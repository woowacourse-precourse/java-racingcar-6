package racingcar.domain.racing.car;

import static racingcar.domain.Constants.MIN_MOVE_NUMBER;

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
        return positions.size() - 1;
    }

    public int calcLastPosition() {
        if (calcLastIndex() == -1) {
            return 0;
        }
        return findPositionAt(calcLastIndex());
    }

    public int calcMaxPosition() {
        return positions.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int findPositionAt(int turn) {
        return positions.get(turn);
    }

    public boolean isCurrPositionSameOrOver(int maxPosition) {
        return calcLastPosition() >= maxPosition;
    }

    private void add(int num) {
        positions.add(num);
    }

    public void addPositionByRandomNum(int randomNum) {
        int lastPosition = calcLastPosition();

        if (randomNum >= MIN_MOVE_NUMBER) {
            lastPosition++;
        }

        add(lastPosition);
    }
}
