package racingcar.domain.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

public record CarResult(
        Name name,
        Position position
) {
    public static CarResult of(Name name, Position position) {
        return new CarResult(name, position);
    }

    public boolean isSamePosition(Position highestPosition) {
        return position.equals(highestPosition);
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
