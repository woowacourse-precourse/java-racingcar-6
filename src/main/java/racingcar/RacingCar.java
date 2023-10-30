package racingcar;

public class RacingCar {
    private String name;
    private int distance = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void drive(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
