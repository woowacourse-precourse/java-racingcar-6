package racingcar.model;

public class Car {
    private static final String ONE_STEP = "-";
    private final String carName;
    private int raceLength;
    private StringBuilder stepDistance;

    public Car(String carName) {
        this.carName = carName;
        this.raceLength = 0;
        this.stepDistance = new StringBuilder();
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void plusOneStep() {
        raceLength += 1;
        stepDistance.append(ONE_STEP);
    }

    public String getCarName() {
        return carName;
    }

    protected String getStepDistance() {
        return stepDistance.toString();
    }
}
