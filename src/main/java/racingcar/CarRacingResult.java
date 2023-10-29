package racingcar;

public class CarRacingResult {
    private final String name;
    private final int location;

    public CarRacingResult(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
