package racingcar.model;

import static racingcar.enums.Symbol.POSITION_MARKER;

import java.util.Objects;

public class RacingCar {
    private final String name;
    private int position;

    private RacingCar(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public static RacingCar from(String name) {
        Objects.requireNonNull(name);
        return new RacingCar(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionMarkers() {
        return POSITION_MARKER.getValue()
                .repeat(this.position);
    }

    public void moveForward() {
        this.position++;
    }
}
