package racingcar.domain;

public class RacingCar {
    public final String name;
    public int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

}
