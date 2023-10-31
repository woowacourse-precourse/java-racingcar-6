package racingcar.engine.domain;

import java.util.StringJoiner;
import racingcar.utils.RandomUtils;

public class Car {
    private static final String PROGRESS_BAR = "-";
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 9;

    private String name;
    private int progress = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        int randomNumber = RandomUtils.getRandomNumber(MINIMUM_VALUE, MAXIMUM_VALUE);

        if (randomNumber >= 4) {
            this.progress++;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(" ", name + " : ", "")
                .add(PROGRESS_BAR.repeat(progress))
                .toString();
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
