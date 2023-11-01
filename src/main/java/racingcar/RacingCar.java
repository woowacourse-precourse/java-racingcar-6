package racingcar;

import racingcar.util.NumberPicker;

public class RacingCar {

    private static final int MOVING_STANDARD = 4;
    private static final int STARTING_POSITION = 0;

    private final String name;
    private int position;
    private final NumberPicker numberPicker;

    public RacingCar(String name, NumberPicker numberPicker) {
        this.name = name;
        this.position = STARTING_POSITION;
        this.numberPicker = numberPicker;
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
        return numberPicker.pickNumber() >= MOVING_STANDARD;
    }
}
