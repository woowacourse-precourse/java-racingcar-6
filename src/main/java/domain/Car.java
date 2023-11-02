package domain;

import utils.RandomUtils;

public class Car {

    private final String name;
    private Progress progress;

    public Car(String name) {
        this.name = name;
        this.progress = new Progress();
    }

    public void moveAhead() {
        this.progress = this.progress.addValue();
    }

    public void moveAheadByRandomNumber() {
        if (RandomUtils.isPossibleMoveAhead()) {
            moveAhead();
        }
    }

    public RaceResult generateResult() {
        int currentProgress = getProgress().getValue();
        String currentName = getName();

        return new RaceResult(currentProgress, currentName);
    }

    public String getName() {
        return this.name;
    }

    public Progress getProgress() {
        return this.progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car otherCar = (Car) o;

        return this.name.equals(otherCar.name);
    }

    @Override
    public int hashCode() {
        if (name == null) {
           return 0;
        }
        return name.hashCode();
    }
}
