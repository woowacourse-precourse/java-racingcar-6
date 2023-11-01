package racingcar.service;

import org.assertj.core.util.VisibleForTesting;

public class RacingCar {
    private static final int THRESHOLD_TO_ADVANCE = 4;
    private final String name;
    private int advanceDistance;

    public RacingCar(String name) {
        this.name = name;
        this.advanceDistance = 0;
    }


    public String getName() {
        return name;
    }

    public int getAdvanceDistance() {
        return advanceDistance;
    }

    public void advanceByNumber(int number) {
        if (isAdvancedTarget(number)) {
            this.advanceDistance++;
        }
    }

    @VisibleForTesting
    protected static boolean isAdvancedTarget(int number) {
        return number >= THRESHOLD_TO_ADVANCE;
    }
}

