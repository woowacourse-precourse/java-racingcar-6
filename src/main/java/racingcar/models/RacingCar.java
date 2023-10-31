package racingcar.models;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= 4) {
            this.distance += 1;
        }
    }
}
