package racingcar.Entity;

import racingcar.Config;
import racingcar.Util;

public class Car {
    private final String name;
    private int step;

    private Car(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public static Car createCar(String name, int step) {
        return new Car(name, step);
    }

    public void run() {
        if (isRunnable()) {
            plusStep(Config.RUN_STEP);
        }
    }

    private void plusStep(int number) {
        this.step += number;
    }

    private boolean isRunnable(){
        int number = Util.getRandomSingleDigit();
        return Util.getBooleanByNumber(number);
    }

    String getName() {
        return name;
    }

    int getStep() {
        return step;
    }
}