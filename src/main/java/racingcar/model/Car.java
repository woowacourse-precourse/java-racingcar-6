package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private static final int cutLine = 4;
    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        if (getRandomNumber() >= cutLine) {
            this.progress++;
        }
    }

    public boolean isSame(Car car) {
        return car.progress == this.progress;
    }

    @Override
    public int compareTo(Car car) {
        return this.progress - car.progress;
    }

    public String getName() {
        return this.name;
    }

    public int getProgress() {
        return this.progress;
    }
}
