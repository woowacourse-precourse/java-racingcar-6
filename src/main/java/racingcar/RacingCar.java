package racingcar;

public class RacingCar {
    private final String name;
    private int location;

    public RacingCar(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void updateLocation() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }
}
