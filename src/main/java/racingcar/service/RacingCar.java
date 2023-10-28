package racingcar.service;

public class RacingCar {
    private final String name;
    private int advanceDistance;

    public RacingCar(String name, int advanceDistance) {
        this.name = name;
        this.advanceDistance = advanceDistance;
    }


    public String getName() {
        return name;
    }

    public int getAdvanceDistance() {
        return advanceDistance;
    }

    public void advance() {
        this.advanceDistance++;
    }
}

