package racingcar.model;

import static racingcar.util.Constant.NEXT_INDEX;

import java.util.HashMap;
import java.util.Map;
import racingcar.exception.position.NotExistPositionException;

public class Position {

    private static final Map<Integer, Position> cache = new HashMap<>();

    private final int positionIndex;

    private Position(int positionIndex) {
        this.positionIndex = positionIndex;
    }

    public static Position createWith(final int positionIndex) {
        return cache.computeIfAbsent(positionIndex, Position::new);
    }

    public Position getNextPosition() {
        return cache.get(getKeyByValue(this) + NEXT_INDEX.getValue());
    }

    private int getKeyByValue(final Position position) {
        return cache.entrySet().stream()
                .filter(entry -> entry.getValue().equals(position))
                .findAny()
                .orElseThrow(() -> new NotExistPositionException(position.getPositionIndex()))
                .getKey();
    }

    public int getPositionIndex() {
        return positionIndex;
    }
}
