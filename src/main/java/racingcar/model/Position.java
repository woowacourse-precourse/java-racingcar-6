package racingcar.model;

import static racingcar.util.Constant.*;

import java.util.HashMap;
import java.util.Map;
import racingcar.exception.position.NotFoundPositionException;

public class Position {

    private static final Map<Integer, Position> cache = new HashMap<>();

    private final int positionIndex;

    private Position(int positionIndex) {
        this.positionIndex = positionIndex;
    }

    public static Position createWith(final int positionIndex) {
        Position position = new Position(positionIndex);
        cache.put(positionIndex, position);
        return position;
    }

    public Position getNextPosition(final Position position) {
        return cache.get(getKeyByValue(position) + NEXT_INDEX.getValue());
    }

    private int getKeyByValue(final Position position) {
        return cache.entrySet().stream()
                .filter(entry -> entry.getValue().equals(position))
                .findAny()
                .orElseThrow(() -> new NotFoundPositionException(position.getPositionIndex()))
                .getKey();
    }

    public int getPositionIndex() {
        return positionIndex;
    }
}
