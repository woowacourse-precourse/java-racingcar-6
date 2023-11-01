package racingcar.domain;

import java.util.Arrays;

public class Car {
    private static final int INIT_PROGRESS = 0;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int progress;

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public static Car createCar(String name) {
        return new Car(name, INIT_PROGRESS);
    }

    public int getProgress() {
        return progress;
    }


    public String getName() {
        return name;
    }

    public boolean sameProgress(int maxProgress) {
        return progress == maxProgress;
    }

    public Car getCar() {
        return new Car(name, progress);
    }

    public void move(int moveTrigger) {
        if (judgeMove(moveTrigger)) {
            progress++;
        }
    }

    private static boolean judgeMove(int moveTrigger) {
        return MOVE_CONDITION <= moveTrigger;
    }

    public void updateProgress(int progress) {
        this.progress = progress;
    }

    public char[] progressBar() {
        char[] bars = new char[getProgress()];
        Arrays.fill(bars, '-');
        return bars;
    }
}
