package racingcar.model;

import java.util.Objects;
import java.util.stream.IntStream;
import racingcar.enums.Symbol;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionMarkers() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, this.position)
                .forEach(i -> stringBuilder.append(Symbol.POSITION_MARKER.getValue()));
        return stringBuilder.toString();
    }

    public void moveForward() {
        this.position++;
    }
}
