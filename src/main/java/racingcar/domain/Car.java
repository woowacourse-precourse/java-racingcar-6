package racingcar.domain;

import static racingcar.constant.RacingGameConstants.DASH;
import static racingcar.constant.RacingGameConstants.INITIAL_PROGRESS;
import static racingcar.constant.RacingGameConstants.MINIMUM_TO_MOVE;

import racingcar.validator.CarMovingValidator;

public class Car {
    private final String name;
    private int progress;

    private Car(String name) {
        this.name = name;
        this.progress = INITIAL_PROGRESS;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public String getDash() {
        return DASH.repeat(progress);
    }

    public void go(int progress) {
        CarMovingValidator.validateMovingNumber(progress);

        if (progress >= MINIMUM_TO_MOVE) {
            this.progress++;
        }
    }
}