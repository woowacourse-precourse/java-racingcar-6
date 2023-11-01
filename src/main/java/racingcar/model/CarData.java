package racingcar.model;

public class CarData {
    private final String carName;
    private final Integer moveDistance;

    public CarData(String inputName, Integer inputScore) {
        this.carName = inputName;
        this.moveDistance = inputScore;
    }

    public String getName() {
        return this.carName;
    }

    public Integer getMoveDistance() {
        return this.moveDistance;
    }
}
