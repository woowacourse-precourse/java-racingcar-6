package racingcar.engine.domain;

import java.util.StringJoiner;

public class Car {
    private static final String PROGRESS_BAR = "-";

    private String name;
    private int progress = 0;

    public Car(String name) {
        this.name = name;
    }

    public void drive(int threshold, int randomNumber) {
        if (randomNumber >= threshold) {
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
