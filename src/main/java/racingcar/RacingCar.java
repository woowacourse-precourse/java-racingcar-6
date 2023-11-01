package racingcar;

import racingcar.util.RangedRandomNumberPicker;

public class RacingCar {

    private static final int MOVING_STANDARD = 4;
    private static final int STARTING_POSITION = 0;

    private final String name;
    private int position;
    private final RangedRandomNumberPicker rangedRandomNumberPicker;

    public RacingCar(String name, RangedRandomNumberPicker rangedRandomNumberPicker) {
        this.name = name;
        this.position = STARTING_POSITION;
        this.rangedRandomNumberPicker = rangedRandomNumberPicker;
    }

    public void race() {
        if (canMoveForward()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMoveForward() {
        return rangedRandomNumberPicker.pickNumber() >= MOVING_STANDARD;
    }
}
