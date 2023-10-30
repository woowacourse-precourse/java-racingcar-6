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
}
